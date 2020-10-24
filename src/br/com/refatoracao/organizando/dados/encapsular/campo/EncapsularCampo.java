package br.com.refatoracao.organizando.dados.encapsular.campo;

public class EncapsularCampo {
   /* antes da refatoracao
    public String nome;*/

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
