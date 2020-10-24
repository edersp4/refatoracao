package br.com.refatoracao.dividir.variavel.temporaria;

/**
 * @author ederson
 * @since 16/09/2020
 * project refatoracao
 */
public class DividirVariavelTemporaria {
    private double forcaPrimaria;
    private double massa;
    private int atraso;
    private double forcaSecundaria;

    public static void main(String[] args) {

    }


    /*
    Antes de refatorar
    public double lerDistanciaViajada(int tempo) {
        double resultado;
        double acel = this.forcaPrimaria / this.massa;
        int tempoPrimario = Math.min(tempo, this.atraso);
        resultado = 0.5 * acel * tempoPrimario * tempoPrimario;
        int tempoSecundario = tempo - this.atraso;
        if (tempoSecundario > 0) {
            double velocidadePrimaria = acel * this.atraso;
            acel = (this.forcaPrimaria + this.forcaSecundaria) / massa;
            resultado += velocidadePrimaria * tempoSecundario + 0.5 * acel * tempoSecundario + 0.5 * acel * tempoSecundario * tempoSecundario;
        }
        return resultado;
    }*/

    public double lerDistanciaViajada(int tempo) {
        double resultado;
        final double aceleracaoPrimaria = this.forcaPrimaria / this.massa;
        int tempoPrimario = Math.min(tempo, this.atraso);
        resultado = 0.5 * aceleracaoPrimaria * tempoPrimario * tempoPrimario;
        int tempoSecundario = tempo - this.atraso;
        if (tempoSecundario > 0) {
            double velocidadePrimaria = aceleracaoPrimaria * this.atraso;
            final double aceleracaoSecundaria = (this.forcaPrimaria + this.forcaSecundaria) / massa;
            resultado += velocidadePrimaria * tempoSecundario + 0.5 * aceleracaoSecundaria * tempoSecundario + 0.5 * aceleracaoSecundaria * tempoSecundario * tempoSecundario;
        }
        return resultado;
    }
}
