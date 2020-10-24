package br.com.refatoracao.organizando.dados.substituir.numeros.magicos.por.constantes.simbolicas;

public class SubstituirNumerosMagicosPorConstantesSimbolicas {
    public static final double CONSTANTE_GRAVITACIONAL = 9.81;
    /* antes da refatoracao
    double energiaPotencial(double massa, double altura) {
        return massa * 9.81 * altura;
    }*/

    double energiaPotencial(double massa, double altura) {
        return massa * CONSTANTE_GRAVITACIONAL * altura;
    }

}
