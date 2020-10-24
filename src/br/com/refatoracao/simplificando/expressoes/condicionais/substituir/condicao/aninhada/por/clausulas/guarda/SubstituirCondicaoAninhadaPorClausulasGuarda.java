package br.com.refatoracao.simplificando.expressoes.condicionais.substituir.condicao.aninhada.por.clausulas.guarda;

/**
 * @author ederson
 * project refatoracao
 * @since 15/10/2020
 */
public class SubstituirCondicaoAninhadaPorClausulasGuarda {
}
/*
antes da refatoracao
class Pagar {

    public static final int FATOR_DE_AJUSTE = 30;
    private boolean estaMorto;
    private boolean estaAposentado;
    private double capital;
    private double juros;
    private double duracao;
    private double renda;


    double obterQuantiaAPagar() {
        double resultado;
        if (estaMorto) {
            resultado = quantiaMorto();
        } else {
            if (estaAposentado)
                resultado = quantiaAposentado();
            else
                resultado = quantiaNormalAPagar();
        }
        return resultado;
    }


    double obterCapitalAjustado() {
        double resultado = 0.0;
        if (capital > 0.0)
            if (juros > 0.0 && duracao > 0.0)
                resultado = (renda / duracao) * FATOR_DE_AJUSTE;

        return resultado;
    }

    private double quantiaNormalAPagar() {
        return 0;
    }

    private double quantiaAposentado() {
        return 0;
    }

    private double quantiaMorto() {
        return 0;
    }
}
*/
class Pagar {

    public static final int FATOR_DE_AJUSTE = 30;
    private boolean estaMorto;
    private boolean estaAposentado;
    private double capital;
    private double juros;
    private double duracao;
    private double renda;

    double obterQuantiaAPagar() {
        if (estaMorto)
            return quantiaMorto();
        if (estaAposentado)
            return quantiaAposentado();
        else
            return quantiaNormalAPagar();
    }

    double obterCapitalAjustado() {
        if (capital <= 0.0) {
            return 0.0;
        }
        if (juros <= 0.0 || duracao <= 0.0) {
            return 0.0;
        }

        return (renda / duracao) * FATOR_DE_AJUSTE;
    }

    private double quantiaNormalAPagar() {
        return 0;
    }

    private double quantiaAposentado() {
        return 0;
    }

    private double quantiaMorto() {
        return 0;
    }
}