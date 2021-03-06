package br.com.alura.forum.controller;

import br.com.alura.forum.controller.Repository.CursoRepository;
import br.com.alura.forum.controller.Repository.TopicoRepository;
import br.com.alura.forum.controller.dto.AttTopicoForm;
import br.com.alura.forum.controller.dto.DetalheTopicoDTO;
import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.dto.TopicoForm;
import br.com.alura.forum.models.Resposta;
import br.com.alura.forum.models.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/topicos")
@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> lista (String nomeCurso){
        List<Topico> topicos;
        if (nomeCurso == null || nomeCurso.isEmpty()){
            topicos = topicoRepository.findAll();
        }else {
            topicos = topicoRepository.findByCursoNome(nomeCurso);
        }
        return  TopicoDTO.conversor(topicos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDTO> cadastro (@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheTopicoDTO> detalhar(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if(topico.isPresent()){
            return ResponseEntity.ok(new DetalheTopicoDTO(topico.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> Atualizar(@PathVariable Long id, @RequestBody @Valid AttTopicoForm form) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            form.atualizar(topico.get(),topicoRepository);
            return ResponseEntity.ok(new TopicoDTO(topico.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Remover(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()) {
            topicoRepository.delete(topico.get());
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
