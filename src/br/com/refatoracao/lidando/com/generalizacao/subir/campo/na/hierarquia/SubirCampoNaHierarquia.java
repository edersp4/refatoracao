package br.com.refatoracao.lidando.com.generalizacao.subir.campo.na.hierarquia;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class SubirCampoNaHierarquia {
}
/*

class Empregado {

}

class Vendedor extends Empregado {
    private String nome;
}

class Engenheiro extends Empregado {
    private String nome
}*/
class Empregado {
    protected String nome;
}

class Vendedor extends Empregado {
}

class Engenheiro extends Empregado {
}






