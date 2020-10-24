package br.com.refatoracao.organizando.dados.encapsular.vetores;

import java.util.Arrays;

public class EncapsularVetores {

    public static void main(String[] args) {
        Vetores vetores = new Vetores();
        vetores.gravarHabilidade(1, "Refatoracao");

        final String[] habilidades = vetores.getHabilidades();
        System.out.println(habilidades.length);
    }

}

/*
Antes da refatoracao
class Vetores {
    private String[] habilidades;

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }
}
*/
class Vetores {
    private String[] habilidades = new String[50];

    public void gravarHabilidade(int index, String novaHabilidade) {
        habilidades[index] = novaHabilidade;
    }

    public void gravarHabilidades(String[] habilidades) {
        this.habilidades = new String[habilidades.length];
        for (int index = 0; index < habilidades.length; index++) {
            gravarHabilidade(index, habilidades[index]);
        }
    }

    public String[] getHabilidades() {
        return Arrays.copyOf(this.habilidades, this.habilidades.length);
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }


}