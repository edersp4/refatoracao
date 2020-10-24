package br.com.refatoracao.remover.intermediario;

public class RemoverIntermediario {
    public static void main(String[] args) {
        final Pessoa pessoa = new Pessoa();
        final Pessoa gerente = pessoa.getDepartamento().getGerente();
//        pessoa.getDepartamento().getGerente()
    }
}


/*
Antes da refatoração

class Pessoa {
    private Departamento departamento;
    public Pessoa getGerente() {
        return departamento.getGerente();
    }
}

class Departamento {

    private final Pessoa gerente;

    Departamento(Pessoa gerente) {
        this.gerente = gerente;
    }


    public Pessoa getGerente() {
        return this.gerente;
    }
}*/


class Pessoa {
    private Departamento departamento;

    public Departamento getDepartamento() {
        return departamento;
    }
}

class Departamento {

    private final Pessoa gerente;

    Departamento(Pessoa gerente) {
        this.gerente = gerente;
    }


    public Pessoa getGerente() {
        return this.gerente;
    }
}