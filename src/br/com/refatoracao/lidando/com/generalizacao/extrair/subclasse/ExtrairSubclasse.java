package br.com.refatoracao.lidando.com.generalizacao.extrair.subclasse;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class ExtrairSubclasse {
    public static void main(String[] args) {
//        ItemServico j1 = new ItemServico(0, 5, true, new Empregado());
        ItemServico j1 = new ItemMaoDeObra(0,  new Empregado());
    }

}
/*

class ItemServico {
    private int precoUnitario;
    private int quantidade;
    private final boolean usaMaoDeObra;
    private final Empregado empregado;

    public ItemServico(int precoUnitario, int quantidade , boolean usaMaoDeObra, Empregado empregado) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.usaMaoDeObra = usaMaoDeObra;
        this.empregado = empregado;
    }


    public int getPrecoTotal() {
        return getPrecoUnitario() * quantidade;
    }
    public int getPrecoUnitario() {
        return usaMaoDeObra ? empregado.getTaxa() : precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isUsaMaoDeObra() {
        return usaMaoDeObra;
    }

    public Empregado getEmpregado() {
        return empregado;
    }
}

class Empregado {

    private int taxa;

    public int getTaxa() {
        return this.taxa;
    }
}
*/
abstract class ItemServico {
    private int precoUnitario;
    private int quantidade;

    protected ItemServico(int precoUnitario, int quantidade) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }


    public int getPrecoTotal() {
        return getPrecoUnitario() * quantidade;
    }
    public int getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    protected boolean isUsaMaoDeObra() {
        return false;
    }

}

class Empregado {

    private int taxa;

    public int getTaxa() {
        return this.taxa;
    }
}

class ItemMaoDeObra extends ItemServico {
    private final Empregado empregado;

    public ItemMaoDeObra(int quantidade, Empregado empregado) {
        super(0, quantidade);
        this.empregado = empregado;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    @Override
    protected boolean isUsaMaoDeObra() {
        return true;
    }

    @Override
    public int getPrecoUnitario() {
        return empregado.getTaxa();
    }
}