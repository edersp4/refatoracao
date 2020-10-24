package br.com.refatoracao.mover.internalizar.classe;

public class InternalizarClasse {

}

/*
Antes de refatorar
class Pessoa {
    private String nome;
    private NumeroTelefone numeroTelefoneEscritorio = new NumeroTelefone();

    public String getNomeCliente() {
        return nome;
    }

    public NumeroTelefone getNumeroTelefoneEscritorio() {
        return numeroTelefoneEscritorio;
    }

    public String getNumeroTelefone() {
        return numeroTelefoneEscritorio.getNumeroTelefone();
    }
}

class NumeroTelefone {
    private String numero;
    private String codigoArea;

    public String getNumero() {
        return numero;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public String getNumeroTelefone() {
        return "(" + codigoArea + ")" + numero;
    }
}*/


class Pessoa {
    private String nome;
    private NumeroTelefone numeroTelefoneEscritorio = new NumeroTelefone();

    public String getNome() {
        return nome;
    }

    public NumeroTelefone getNumeroTelefoneEscritorio() {
        return numeroTelefoneEscritorio;
    }

    public String getNumero() {
        return numeroTelefoneEscritorio.getNumero();
    }

    public String getCodigoArea() {
        return numeroTelefoneEscritorio.getCodigoArea();
    }

    public String getNumeroTelefone() {
        return "(" + getCodigoArea() + ")" + getNumero();
    }
}

class NumeroTelefone {
    private String numero;
    private String codigoArea;

    public String getNumero() {
        return numero;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public String getNumeroTelefone() {
        return "(" + codigoArea + ")" + numero;
    }
}