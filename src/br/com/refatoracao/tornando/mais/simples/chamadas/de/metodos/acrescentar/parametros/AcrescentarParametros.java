package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.acrescentar.parametros;

/**
 * @author ederson
 * project refatoracao
 * @since 19/10/2020
 */
/*
Antes da refatoracao
public class AcrescentarParametros {

    public void calculaAlgumaCoisa(int numero) {
        System.out.println("numero = " + numero);
    }
}

class Calculo {


    public void calculoAnterior() {
        new AcrescentarParametros().calculaAlgumaCoisa(23);
    }
}

*/

public class AcrescentarParametros {

    public void calculaAlgumaCoisa(int numero, String message) {
        System.out.println("numero = " + numero);
    }
}

class Calculo {


    public void calculoAnterior() {
        new AcrescentarParametros().calculaAlgumaCoisa(23, "");
    }
}