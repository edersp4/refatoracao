package br.com.refatoracao.lidando.com.generalizacao.subir.campo.corpo.construtor.na.hierarquia;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class SubirCorpoDoConstrutorNaHierarquia {
}
/*

class Empregado {
    protected String nome;
    protected String id;
}

class Gerente extends Empregado {
    private final int grau;

    public Gerente(String nome, String id, int grau) {
        super.nome = nome;
        super.id = id;
        this.grau = grau;
    }
}*/

class Empregado {
    protected String nome;
    protected String id;

    protected Empregado(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }
}

class Gerente extends Empregado {
    private final int grau;

    public Gerente(String nome, String id, int grau) {
        super(nome, id);
        this.grau = grau;
    }

}


/**
 * Neste caso eu tenho uma validação que não pode ser executada no começo do construtor
 * porém eu tenho esses métodos em comum nas duas subclasses
 * Então eu precisao extrair o método comum e mandar para o construtor pai
 */

/*class EmpregadoComMetodoComum {
    protected String nome;
    protected String id;

    protected EmpregadoComMetodoComum(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }
}

class GerenteComMetodoComum extends EmpregadoComMetodoComum {
    private final int grau;

    public GerenteComMetodoComum(String nome, String id, int grau) {
        super(nome, id);
        this.grau = grau;
        if(temPrivilegios())// toda classe tem isso
            designarAutomovel();// toda classe tem isso
    }

    boolean temPrivilegios() {
        return true;
    }

    void designarAutomovel() {

    }

}*/

abstract class EmpregadoComMetodoComum {
    protected String nome;
    protected String id;

    protected EmpregadoComMetodoComum(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    protected void inicializar() {
        if (temPrivilegios())// toda classe tem isso
            designarAutomovel();// toda classe tem isso
    }

    abstract boolean temPrivilegios();

    abstract void designarAutomovel();
}

class GerenteComMetodoComum extends EmpregadoComMetodoComum {
    private final int grau;

    public GerenteComMetodoComum(String nome, String id, int grau) {
        super(nome, id);
        this.grau = grau;
        super.inicializar();
    }

    @Override
    boolean temPrivilegios() {
        return grau > 4;
    }

    @Override
    void designarAutomovel() {

    }

}