package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.remover.parametro;

/**
 * @author ederson
 * project refatoracao
 * @since 19/10/2020
 */
/*

antes da refatoracao
public class RemoverParametro {
    public void calculaAlgumaCoisa(int numero, String message) {
        System.out.println("numero = " + numero);
    }
}


class Calculo {
    public void calculoAnterior() {
        new RemoverParametro().calculaAlgumaCoisa(23, "");
    }
}*/


public class RemoverParametro {
    public void calculaAlgumaCoisa(int numero) {
        System.out.println("numero = " + numero);
    }
}


class Calculo {
    public void calculoAnterior() {
        new RemoverParametro().calculaAlgumaCoisa(23);
    }
}