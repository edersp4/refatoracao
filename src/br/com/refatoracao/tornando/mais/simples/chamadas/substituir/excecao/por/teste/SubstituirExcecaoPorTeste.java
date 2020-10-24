package br.com.refatoracao.tornando.mais.simples.chamadas.substituir.excecao.por.teste;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class SubstituirExcecaoPorTeste {
}

class ConjuntoDeRecursos {
  /*  private Stack<Recurso> disponivel;
    private Stack<Recurso> alocado;

    Recurso getRecurso() {
        Recurso resultado;

        try {
            resultado = disponivel.pop();
            alocado.push(resultado);
            return resultado;
        } catch (Exception e) {
            resultado = new Recurso();
            alocado.push(resultado);
            return resultado;
        }
    }*/

    private Stack<Recurso> disponivel;
    private Stack<Recurso> alocado;

    Recurso getRecurso() {
        Recurso resultado;

        if (disponivel.isEmpty())
            resultado = new Recurso();
        else
            resultado = disponivel.pop();

        alocado.push(resultado);
        return resultado;
    }
}


class Recurso {

}