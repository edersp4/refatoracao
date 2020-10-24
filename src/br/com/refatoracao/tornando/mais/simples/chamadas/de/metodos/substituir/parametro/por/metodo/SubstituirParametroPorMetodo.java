package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.substituir.parametro.por.metodo;

/**
 * @author ederson
 * project refatoracao
 * @since 21/10/2020
 */
public class SubstituirParametroPorMetodo {
}
/*

class PrecoDoProduto {
    private double precoItem;
    private int quantidade;

    public double getPreco() {
        double precoBase = quantidade * precoItem;
        int nivelDesconto;
        if (quantidade > 100)
            nivelDesconto = 2;
        else
            nivelDesconto = 1;

        return precoComDesconto(precoBase, nivelDesconto);
    }

    private double precoComDesconto(double precoBase, int nivelDesconto) {
        if (nivelDesconto == 2)
            return precoBase * 0.1;
        else
            return precoBase * 0.05;
    }
}*/

class PrecoDoProduto {
    private double precoItem;
    private int quantidade;

    public double getPreco() {
        if (getNivelDesconto() == 2)
            return quantidade * 0.1 * precoItem;
        else
            return quantidade * precoItem * 0.05;
    }

    private int getNivelDesconto() {
        int nivelDesconto;
        if (quantidade > 100)
            nivelDesconto = 2;
        else
            nivelDesconto = 1;
        return nivelDesconto;
    }

}