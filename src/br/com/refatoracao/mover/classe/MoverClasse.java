package br.com.refatoracao.mover.classe;

/**
 * @author ederson
 * @since 17/09/2020
 * project refatoracao
 */
public class MoverClasse {

}
/*

Antes da refartoracao
class Pessoa {

    private String nome;
    private String codigoAreaEscritorio;
    private String numeroEscritorio;

    public String lerNome() {
        return nome;
    }

    public String lerNumerTelefone() {
        return ("(" + this.codigoAreaEscritorio + ")" + this.numeroEscritorio);
    }

    public String getNomeCliente() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoAreaEscritorio() {
        return codigoAreaEscritorio;
    }

    public void setCodigoAreaEscritorio(String codigoAreaEscritorio) {
        this.codigoAreaEscritorio = codigoAreaEscritorio;
    }

    public String getNumeroEscritorio() {
        return numeroEscritorio;
    }

    public void setNumeroEscritorio(String numeroEscritorio) {
        this.numeroEscritorio = numeroEscritorio;
    }

}*/


class Pessoa {

    private String nome;


    private NumeroTelefone numeroTelefone = new NumeroTelefone();

    public String lerNome() {
        return nome;
    }

    public String lerNumerTelefone() {
        return ("(" + numeroTelefone.getCodigoAreaEscritorio() + ")" + numeroTelefone.getNumeroEscritorio());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

class NumeroTelefone {
    private String codigoAreaEscritorio;
    private String numeroEscritorio;

    public String getCodigoAreaEscritorio() {
        return codigoAreaEscritorio;
    }

    public void setCodigoAreaEscritorio(String codigoAreaEscritorio) {
        this.codigoAreaEscritorio = codigoAreaEscritorio;
    }

    public String getNumeroEscritorio() {
        return numeroEscritorio;
    }

    public void setNumeroEscritorio(String numeroEscritorio) {
        this.numeroEscritorio = numeroEscritorio;
    }
}
