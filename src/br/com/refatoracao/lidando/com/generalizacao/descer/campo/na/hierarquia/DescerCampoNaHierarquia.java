package br.com.refatoracao.lidando.com.generalizacao.descer.campo.na.hierarquia;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class DescerCampoNaHierarquia {

}
/*
class Empregado {
    protected String quota;
}

class Vendedor extends Empregado {
}

class Engenheiro extends Empregado {
}*/

class Empregado {
}

class Vendedor extends Empregado {
    private double quota;
}

class Engenheiro extends Empregado {
}