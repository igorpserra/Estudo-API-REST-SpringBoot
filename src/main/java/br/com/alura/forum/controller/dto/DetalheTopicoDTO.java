package br.com.alura.forum.controller.dto;

import br.com.alura.forum.models.StatusTopico;
import br.com.alura.forum.models.Topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalheTopicoDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime datacriacao;
    private StatusTopico status;
    private String nomeAutor;
    private String nomeCurso;
    private List<RespostaDTO> respostas;


    public DetalheTopicoDTO(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.datacriacao = topico.getDataCriacao();
        this.status = topico.getStatus();
        this.nomeAutor = topico.getAutor().getNome();
        this.nomeCurso = topico.getCurso().getNome();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public List<RespostaDTO> getRespostas() {
        return respostas;
    }
}
