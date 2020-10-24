package br.com.refatoracao.simplificando.expressoes.condicionais.decompor.condicional;

import java.util.Date;

/**
 * @author ederson
 * project refatoracao
 * @since 14/10/2020
 */
public class DecomporCondicional {
}



class Taxa{

    public static final Date FIM_VERAO = new Date();
    public final Date INICIO_VERAO = new Date();
    private Date data;
    private double aCobrar;
    private int quantidade;
    private double taxaDeInverno;
    private double precoDoInverno;
    private double taxaDeVerao;

   /*
   Antes da refatoracao
   public void calcularTaxa() {
        if (data.before(INICIO_VERAO) || data.after(FIM_VERAO))
            this.aCobrar = this.quantidade * this.taxaDeInverno + precoDoInverno;
        else
            aCobrar = quantidade * taxaDeVerao;

    }*/


    public void calcularTaxa() {
        if (naoEhVerao())
            this.aCobrar = precoInverno();
        else
            aCobrar = precoVerao();

    }

    private double precoInverno() {
        return this.quantidade * this.taxaDeInverno + precoDoInverno;
    }

    private double precoVerao() {
        return quantidade * taxaDeVerao;
    }

    private boolean naoEhVerao() {
        return data.before(INICIO_VERAO) || data.after(FIM_VERAO);
    }
}