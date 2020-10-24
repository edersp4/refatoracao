package br.com.refatoracao.organizando.dados.encapsular.colecao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EncapsularColecao {

    public static void main(String[] args) {
       /*
       antes da refatoracao
       final Pessoa kent = new Pessoa();
        Set<Curso> cursos = new HashSet<>();

        cursos.add(new Curso("Programacao Smallltalk", false));
        cursos.add(new Curso("Apreciando Maltes Únicos", true));
        kent.setCursos(cursos);
        final Curso refatoracao = new Curso("Refatoracao", true);
        kent
                .getCursos()
                .add(refatoracao);

        kent
                .getCursos()
                .add(new Curso("Ironia Brutal", false));


        kent
                .getCursos()
                .remove(refatoracao);

        final long count = kent
                            .getCursos()
                            .stream()
                            .filter(Curso::isEhAvancado)
                            .count();

        System.out.println("count = " + count);*/

        final Pessoa kent = new Pessoa();
        Set<Curso> cursos = new HashSet<>();

        cursos.add(new Curso("Programacao Smallltalk", false));
        cursos.add(new Curso("Apreciando Maltes Únicos", true));
        kent.inicializarCursos(cursos);
        final Curso refatoracao = new Curso("Refatoracao", true);

        kent
                .acrescentarCurso(refatoracao);

        kent
                .acrescentarCurso(new Curso("Ironia Brutal", false));


        kent
                .removerCurso(refatoracao);

        final long count = kent.numeroDeCursosAvancados();

        System.out.println("count = " + count);

    }

}

class Curso {
    private String nome;
    private boolean ehAvancado;

    public Curso(String nome, boolean ehAvancado) {

        this.nome = nome;
        this.ehAvancado = ehAvancado;
    }

    public boolean isEhAvancado() {
        return ehAvancado;
    }
}
/*
antes da refatoracao
class Pessoa {

    private Set<Curso> cursos;

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void inicializarCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}*/
class Pessoa {

    private final Set<Curso> cursos = new HashSet<>();

    long numeroDeCursosAvancados() {
        return this
                .getCursos()
                .stream()
                .filter(Curso::isEhAvancado)
                .count();
    }

    public void inicializarCursos(Set<Curso> cursos) {
        this.cursos.addAll(cursos);
    }

    public void acrescentarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void removerCurso(Curso curso) {
        this.cursos.remove(curso);
    }

    public Set<Curso> getCursos() {
        return Collections.unmodifiableSet(cursos);
    }

    public int numeroDeCursos() {
        return this
                .getCursos()
                .size();
    }

}