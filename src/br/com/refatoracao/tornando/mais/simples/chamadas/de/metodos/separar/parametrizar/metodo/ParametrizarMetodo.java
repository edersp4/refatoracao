package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.separar.parametrizar.metodo;

/**
 * @author ederson
 * project refatoracao
 * @since 19/10/2020
 */
public class ParametrizarMetodo {
}

class Empregado {

   /*

   Antes da refatoracao
    private double salario;

    void aumentarDezPorCento() {
        salario *= 1.1;
    }


    void aumentarCincoPorCento() {
        salario *= 1.05;
    }
   */


    private double salario;

    private void aumentarPorcentagem(double fator) {
        salario *= (1 + fator);
    }


/*
Antes da refatoracao
    public Dolares baseDeCobranca() {
        double resultado = Math.min(ultimoUso(), 100) * 0.03;

        if (ultimoUso() > 100)
            resultado += (Math.min(ultimoUso(), 200) - 100) * 0.05;
        if(ultimoUso() > 200)
            resultado += (ultimoUso() - 200) * 0.07;

        return new Dolares(resultado);
    }
*/


    public Dolares baseDeCobranca() {
        double resultado = usoNaFaixa(Math.min(ultimoUso(), 100), 0.03);

        if (ultimoUso() > 100)
            resultado += usoNaFaixa(Math.min(ultimoUso(), 200) - 100, 0.05);
        if(ultimoUso() > 200)
            resultado += usoNaFaixa(ultimoUso() - 200, 0.07);

        return new Dolares(resultado);
    }

    private double usoNaFaixa(int inicio, double fim) {
        return inicio * fim;
    }

    private int ultimoUso() {
        return 0;
    }


}

class Dolares {

    public Dolares(double resultado) {

    }
}