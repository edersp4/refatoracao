package br.com.refatoracao.simplificando.expressoes.condicionais.introduzir.assercao;

/**
 * @author ederson
 * project refatoracao
 * @since 17/10/2020
 */
public class IntroduzirAssercao {
}
/*

class Empregado {
    private static final double GASTO_NULO = -1.0;
    private double limiteDeGasto = GASTO_NULO;
    private Projeto projetoImportante;

    public double getLimiteDeGasto() {
        return limiteDeGasto != GASTO_NULO ? limiteDeGasto : projetoImportante.getLimiteGastosParticipante();
    }

    boolean isDentroDoLimite(double quantiaGasta) {
        return quantiaGasta <= getLimiteDeGasto();
    }
}

class Projeto {

    public double getLimiteGastosParticipante() {
        throw new RuntimeException("Not implemented yet!!!!");
    }
}*/



class Empregado {
    private static final double GASTO_NULO = -1.0;
    private double limiteDeGasto = GASTO_NULO;
    private Projeto projetoImportante;

    public double getLimiteDeGasto() {
        assert limiteDeGasto != GASTO_NULO || projetoImportante != null;
        return limiteDeGasto != GASTO_NULO ? limiteDeGasto : projetoImportante.getLimiteGastosParticipante();
    }

    boolean isDentroDoLimite(double quantiaGasta) {
        return quantiaGasta <= getLimiteDeGasto();
    }
}

class Projeto {

    public double getLimiteGastosParticipante() {
        throw new RuntimeException("Not implemented yet!!!!");
    }
}