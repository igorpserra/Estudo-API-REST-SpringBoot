package br.com.alura.forum.controller.dto;

import br.com.alura.forum.models.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime datacriacao;

    public TopicoDTO(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.datacriacao = topico.getDataCriacao();
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

    public static List<TopicoDTO> conversor (List<Topico> topicos){
        return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
    }
}
