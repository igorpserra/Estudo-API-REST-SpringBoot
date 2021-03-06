package br.com.alura.forum.config;

public class ErroValidacaoDTO {

    private String erro;
    private String campo;

    public ErroValidacaoDTO(String erro, String campo) {
        this.erro = erro;
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }


    public String getCampo() {
        return campo;
    }

}
