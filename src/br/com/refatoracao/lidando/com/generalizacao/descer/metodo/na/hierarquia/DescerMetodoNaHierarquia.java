package br.com.refatoracao.lidando.com.generalizacao.descer.metodo.na.hierarquia;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class DescerMetodoNaHierarquia {
}

/*
class Empregado {

    protected double getQuota() {
        return 50;
    }
}

class Vendedor extends Empregado {
    private String nome;
}

class Engenheiro extends Empregado {
    private String nome;
}
*/

class Empregado {

}

class Vendedor extends Empregado {
    private String nome;

    protected double getQuota() {
        return 50;
    }
}

class Engenheiro extends Empregado {
    private String nome;

}