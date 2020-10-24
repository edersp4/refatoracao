package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.preservar.objeto.inteiro;

/**
 * @author ederson
 * project refatoracao
 * @since 21/10/2020
 */
public class PreservarObjetoInteiro {
}

/*

class Aposento {
    boolean dentroDoPlano(PlanoDeAquecimento plano) {
        int minima = historicoTemperaturas().getMinima();
        int maxima = historicoTemperaturas().getMaxima();
        return plano.dentroDaFaixa(minima, maxima);
    }

    private HistoricoTemperatura historicoTemperaturas() {
        return new HistoricoTemperatura(10, 30);
    }
}

class PlanoDeAquecimento {

    public boolean dentroDaFaixa(int minima, int maxima) {
        return minima > 30 && maxima < 50;
    }
}

class HistoricoTemperatura {
    private final int minima;
    private final int maxima;

    HistoricoTemperatura(int minima, int maxima) {
        this.minima = minima;
        this.maxima = maxima;
    }

    public int getMinima() {
        return minima;
    }

    public int getMaxima() {
        return maxima;
    }
}*/



class Aposento {
    boolean dentroDoPlano(PlanoDeAquecimento plano) {
        return plano.dentroDaFaixa(historicoTemperaturas());
    }

    private HistoricoTemperatura historicoTemperaturas() {
        return new HistoricoTemperatura(10, 30);
    }
}

class PlanoDeAquecimento {

    public boolean dentroDaFaixa(HistoricoTemperatura historicoTemperatura) {
        return historicoTemperatura.getMinima() > 30 && historicoTemperatura.getMaxima() < 50;
    }
}

class HistoricoTemperatura {
    private final int minima;
    private final int maxima;

    HistoricoTemperatura(int minima, int maxima) {
        this.minima = minima;
        this.maxima = maxima;
    }

    public int getMinima() {
        return minima;
    }

    public int getMaxima() {
        return maxima;
    }
}