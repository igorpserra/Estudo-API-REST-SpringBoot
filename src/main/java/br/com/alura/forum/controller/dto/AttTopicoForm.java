package br.com.alura.forum.controller.dto;

import br.com.alura.forum.controller.Repository.TopicoRepository;
import br.com.alura.forum.models.Topico;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AttTopicoForm {
    @NotEmpty @NotNull
    private String titulo;
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico atualizar(Topico topico, TopicoRepository topicoRepository) {
        topico.setMensagem(this.mensagem);
        topico.setTitulo(this.titulo);
        return topico;
    }
}
