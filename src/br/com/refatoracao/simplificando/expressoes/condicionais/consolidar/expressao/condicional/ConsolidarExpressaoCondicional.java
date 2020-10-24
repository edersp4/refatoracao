package br.com.refatoracao.simplificando.expressoes.condicionais.consolidar.expressao.condicional;

/**
 * @author ederson
 * project refatoracao
 * @since 14/10/2020
 */
public class ConsolidarExpressaoCondicional {
}

/*
antes da refatoracao
class ValorPorIncapacidade {


    private int antiguidade;
    private int mesesIncapacitado;
    private boolean ehTempoParcial;

    double calculoValorPorIncacidade() {
        if (antiguidade < 2)
            return 0;
        if (mesesIncapacitado > 12)
            return 0;
        if(ehTempoParcial)
            return 0;
        else {
            return 1;
        }
    }

    double calculoFerias() {
        if (emFerias())
            if (duracaoDoServico() > 10)
                return 1;

        return 0.5;


    }

}
*/
class ValorPorIncapacidade {


    private int antiguidade;
    private int mesesIncapacitado;
    private boolean ehTempoParcial;

    double calculoValorPorIncacidade() {
        if (naoPreencherRequisitosParaIncapacidade())
            return 0;
        else {
            return 1;
        }
    }

    double calculoFerias() {
        return emFerias() && duracaoDoServico() > 10 ? 1 : 0.5;
    }

    private int duracaoDoServico() {
        return 30;
    }

    private boolean emFerias() {
        return false;
    }

    private boolean naoPreencherRequisitosParaIncapacidade() {
        return antiguidade < 2 || mesesIncapacitado > 12 || ehTempoParcial;
    }
}