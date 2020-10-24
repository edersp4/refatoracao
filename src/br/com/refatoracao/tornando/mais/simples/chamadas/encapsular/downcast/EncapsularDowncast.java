package br.com.refatoracao.tornando.mais.simples.chamadas.encapsular.downcast;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class EncapsularDowncast {
/*

    public static void main(String[] args) {
        Pessoa advogado = new Advogado();
        if (advogado instanceof Advogado)
            ((Advogado) advogado).setOab(45654);

    }
*/

    public static void main(String[] args) {
        Pessoa advogado = new Advogado();
        final Advogado advogado1 = getAdvogado(advogado);
        advogado1.setOab(1231321);

    }

    private static Advogado getAdvogado(Pessoa advogado) {
        if (advogado instanceof Advogado)
            return ((Advogado) advogado);
        return null;
    }

}

class Pessoa {
    private String nome;
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}

class Engenheiro extends Pessoa {
    private Integer crea;

    public Integer getCrea() {
        return crea;
    }

    public void setCrea(Integer crea) {
        this.crea = crea;
    }
}

class Advogado extends Pessoa {
    private Integer oab;

    public Integer getOab() {
        return oab;
    }

    public void setOab(Integer oab) {
        this.oab = oab;
    }
}