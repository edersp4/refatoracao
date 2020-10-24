package br.com.refatoracao.mover.delegacao;

public class OcultarComDelegacao {
    private Departamento departamento;

    public void test() {
        departamento = new Departamento(new Pessoa());
        final Pessoa jhon = new Pessoa();
        jhon.getGerente();

        departamento.getGerente();
    }
}

/*

Antes da Refatoracao
class Pessoa {
    Departamento departamento;

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Pessoa getGerente() {
        return departamento.getGerente();
    }
}
*/


class Pessoa {
    Departamento departamento;

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Pessoa getGerente() {
        return departamento.getGerente();
    }
}

class Departamento {
    private String codigoCobranca;
    private Pessoa gerente;

    public Departamento(Pessoa gerente) {
        this.gerente = gerente;
    }

    public Pessoa getGerente() {
        return gerente;
    }
}


