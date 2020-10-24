package br.com.refatoracao.mover.metodo;

/**
 * @author ederson
 * @since 16/09/2020
 * project refatoracao
 */
public class MoverMetodo {
    private Tipo tipo;
    private int diasDescobertos;

   /* Antes da refatoracao
   double cobrancaPorSaqueADescoberto() {

        if (this.tipo.isPremium()) {
            double resultado = 10;
            if (this.diasDescobertos > 7)
                resultado += (this.diasDescobertos - 7) * 0.85;
            return resultado;

        } else
            return this.diasDescobertos * 1.75;

    }*/


        double tarifaBancaria() {
        double resultado = 4.5;
        if (this.diasDescobertos > 0)
            resultado += tipo.cobrancaPorSaqueADescoberto(diasDescobertos);
        return resultado;
    }


}

class Tipo {
    public boolean premium;

    public boolean isPremium() {
        return this.premium;
    }

    public double cobrancaPorSaqueADescoberto(int diasDescobertos) {
        if (isPremium()) {
            double resultado = 10;
            if (diasDescobertos > 7)
                resultado += (diasDescobertos - 7) * 0.85;
            return resultado;

        } else
            return diasDescobertos * 1.75;

    }
}
