package br.com.refatoracao.organizando.dados.auto.encapsular.campo;

public class AutoEncapsularCampo {
}

class FaixaInt {
    private int alto;
    private int baixo;


   /*
   Antes da refatoracao
   public FaixaInt(int alto, int baixo) {
        this.alto = alto;
        this.baixo = baixo;
    }

    boolean inclui(int arg) {
        return arg >= baixo && arg <= alto;
    }

    void crescer(int fator) {
        alto = alto * fator;
    }
*/

    public FaixaInt(int alto, int baixo) {
        this.alto = alto;
        this.baixo = baixo;
    }

    boolean inclui(int arg) {
        return arg >= getBaixo() && arg <= getAlto();
    }

    void crescer(int fator) {
        setAlto(alto * fator);
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getBaixo() {
        return baixo;
    }

    public void setBaixo(int baixo) {
        this.baixo = baixo;
    }
}

class FaixaLimitada extends FaixaInt {
    private final int limite;

    public FaixaLimitada(int alto, int baixo, int limite) {
        super(alto, baixo);
        this.limite = limite;
    }

    public int getLimite() {
        return limite;
    }


    @Override
    public int getAlto() {
        return Math.min(super.getAlto(), getLimite());
    }
}