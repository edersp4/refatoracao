package br.com.refatoracao.lidando.com.generalizacao.extrair.superclasse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class ExtrairSuperClasse {

}


/*
class Empregado {
    private final String nome;
    private final String id;
    private final int custoAnual;

    public Empregado(String nome , String id , int custoAnual) {
        this.nome = nome;
        this.id = id;
        this.custoAnual = custoAnual;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public int getCustoAnual() {
        return custoAnual;
    }
}

class Departamento {
    private final String nome;
    private List<Empregado> pessoas = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public int getCustoAnualTotal() {
        int resultado = 0;
        for (Empregado pessoa : getPessoas()) {
            resultado += pessoa.getCustoAnual();
        }
        return resultado;
    }

    public String getNome() {
        return nome;
    }

    public List<Empregado> getPessoas() {
        return pessoas;
    }

    public int getNumeroPessoas() {
        return this.pessoas.size();
    }

    public void adicionarPessoas(Empregado empregado) {
        this.pessoas.add(empregado);
    }
}*/
class Empregado extends Grupo{
    private final String id;
    private final int custoAnual;

    public Empregado(String nome , String id , int custoAnual) {
        super(nome);
        this.id = id;
        this.custoAnual = custoAnual;
    }

    public String getId() {
        return id;
    }

    public int getCustoAnual() {
        return custoAnual;
    }
}

class Departamento extends Grupo{
    private List<Empregado> pessoas = new ArrayList<>();

    public Departamento(String nome) {
        super(nome);
    }

    public int getCustoAnual() {
        int resultado = 0;
        for (Empregado pessoa : getPessoas()) {
            resultado += pessoa.getCustoAnual();
        }
        return resultado;
    }

    public List<Empregado> getPessoas() {
        return pessoas;
    }

    public int getNumeroPessoas() {
        return this.pessoas.size();
    }

    public void adicionarPessoas(Empregado empregado) {
        this.pessoas.add(empregado);
    }
}

class Grupo {

    private String nome;

    protected Grupo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
