package br.com.alura.forum.controller.dto;

import br.com.alura.forum.models.Resposta;
import br.com.alura.forum.models.Usuario;

import java.time.LocalDateTime;

public class RespostaDTO {
    private Long id;
    private LocalDateTime dataCriacao;
    private String mensagem;
    private String autor;

    public RespostaDTO (Resposta resposta){
        this.id = resposta.getId();
        this.dataCriacao = resposta.getDataCriacao();
        this.mensagem = resposta.getMensagem();
        this.autor = resposta.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getAutor() {
        return autor;
    }
}
