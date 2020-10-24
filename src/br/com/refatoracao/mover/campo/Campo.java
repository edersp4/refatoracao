package br.com.refatoracao.mover.campo;

/**
 * @author ederson
 * @since 17/09/2020
 * project refatoracao
 */
public class Campo {
}
/*
Antes da refatoracao
class Conta {
    private TipoConta tipoConta;
    private double taxaJuros;
    double jurosPorGarantia(double quantia, int dias) {
        return taxaJuros * quantia * dias / 365;
    }

}*/
class Conta {
    private TipoConta tipoConta;

    double jurosPorGarantia(double quantia, int dias) {
        return tipoConta.lerTaxaJuros() * quantia * dias / 365;
    }

}

class TipoConta {
    private double taxaJuros;

    void gravarTaxaJuros(double arg) {
        taxaJuros = arg;
    }

    double lerTaxaJuros() {
        return taxaJuros;
    }

}