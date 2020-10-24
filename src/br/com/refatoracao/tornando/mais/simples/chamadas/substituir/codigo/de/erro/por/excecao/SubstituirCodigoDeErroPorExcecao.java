package br.com.refatoracao.tornando.mais.simples.chamadas.substituir.codigo.de.erro.por.excecao;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class SubstituirCodigoDeErroPorExcecao {
}

class ContaExcecaoNaoVerificada {

  /*  private double saldo;

    int retirada(int quantia) {
        if (quantia > saldo)
            return -1;
        else
            saldo -= quantia;
        return 0;
    }*/

    private double saldo;

    int retirada(double quantia) {
        if (quantia > saldo)
            throw new IllegalArgumentException("Quantia grande demais ");
        else
            saldo -= quantia;
        return 0;
    }

    public boolean possoRetirar(double quantia) {
        return false;
    }
}

class Cliente {
    private ContaExcecaoNaoVerificada contaExcecaoNaoVerificada = new ContaExcecaoNaoVerificada();
    private ContaExcecaoVerificada contaExcecaoVerificada = new ContaExcecaoVerificada();
    private ContaExcecaoVerificadaComMetodoIntermediario contaExcecaoVerificadaComMetodoIntermediario =
            new ContaExcecaoVerificadaComMetodoIntermediario();
/*
    public void processarConta() {
        if(conta.retirada(12) == -1)
            tratarSaqueADescoberto();
        else
            sigaOProcedimentoNormal();
    }*/

    public void processarContaExcecaoNaoVerificada(double quantia) {
        if (!contaExcecaoNaoVerificada.possoRetirar(quantia)) {
            tratarSaqueADescoberto();
        } else {
            contaExcecaoNaoVerificada.retirada(quantia);
            sigaOProcedimentoNormal();
        }
    }

    public void processarContaExcecaoVerificada(double quantia) {
        try {
            contaExcecaoVerificada.retirada(quantia);
            sigaOProcedimentoNormal();
        } catch (ExcecaoDeSaldo excecaoDeSaldo) {
            tratarSaqueADescoberto();
        }
    }

    public void processarContaExcecaoVerificacaComMetodoIntermediario(double quantia) {
        try {
            contaExcecaoVerificadaComMetodoIntermediario.novaRetirada(quantia);
            sigaOProcedimentoNormal();
        } catch (ExcecaoDeSaldo excecaoDeSaldo) {
            excecaoDeSaldo.printStackTrace();
            tratarSaqueADescoberto();
        }
    }

    private void sigaOProcedimentoNormal() {

    }

    private void tratarSaqueADescoberto() {

    }
}


class ContaExcecaoVerificada {

  /*  private double saldo;

    int retirada(int quantia) {
        if (quantia > saldo)
            return -1;
        else
            saldo -= quantia;
        return 0;
    }*/

    private double saldo;


    void retirada(double quantia) throws ExcecaoDeSaldo {
        if (quantia > saldo) {
            throw new ExcecaoDeSaldo();
        } else {
            saldo -= quantia;
        }
    }
}



class ContaExcecaoVerificadaComMetodoIntermediario {

  /*
  Quando precisamos mudar em muitos clientes que não tratam a excessão
  podemos criar uma método intermediário para que a refatoração possa ser feito gradualmente
  private double saldo;

    int retirada(int quantia) {
        if (quantia > saldo)
            return -1;
        else
            saldo -= quantia;
        return 0;
    }*/

    private double saldo;

    int retirada(int quantia) {

        try {
            novaRetirada(quantia);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    void novaRetirada(double quantia) throws ExcecaoDeSaldo {
        if (quantia > saldo) {
            throw new ExcecaoDeSaldo();
        } else {
            saldo -= quantia;
        }
    }

}

// ------- Exceção não verificada ---------------------
class ExcecaoDeSaldo extends Exception {

}




















