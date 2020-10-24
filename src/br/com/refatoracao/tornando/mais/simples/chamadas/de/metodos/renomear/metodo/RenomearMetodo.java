package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.renomear.metodo;

/**
 * @author ederson
 * project refatoracao
 * @since 19/10/2020
 */
public class RenomearMetodo {
    private String codigoDeAreaDoEscritorio;
    private String numeroDoEscritorio;

    /*
    antes da refatoracao
    public String getNumeroDoTelefone() {
        return ("(" + codigoDeAreaDoEscritorio + ")" + numeroDoEscritorio);
    }*/

     // opcao 1
    /*public String getNumeroDoTelefoneDoEscritorio() {
        return ("(" + codigoDeAreaDoEscritorio + ")" + numeroDoEscritorio);
    }*/


    // passo 1
    public String getNumeroDoTelefone() {
        return getNumeroDeTelefoneDoEscritorio();
    }
    // passo 2 deletar o metodo anterior
    private String getNumeroDeTelefoneDoEscritorio() {
        return "(" + codigoDeAreaDoEscritorio + ")" + numeroDoEscritorio;
    }

    /*public String getNumeroDoTelefoneDoEscritorio() {
        return ("(" + codigoDeAreaDoEscritorio + ")" + numeroDoEscritorio);
    }*/

}
