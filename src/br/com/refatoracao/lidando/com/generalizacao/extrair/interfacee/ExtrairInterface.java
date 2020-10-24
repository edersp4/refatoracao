package br.com.refatoracao.lidando.com.generalizacao.extrair.interfacee;

import org.jetbrains.annotations.NotNull;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class ExtrairInterface {

    public static void main(String[] args) {
    }


}

/*
class Cobranca {
    double cobrar(Empregado empregado, int dias) {
        int base = empregado.getDiaria() * dias;
        if (empregado.temHabilidadeEspecial())
            return base * 1.05;
        else
            return base;
    }
}


class Empregado {

    public int getDiaria() {
        return 0;
    }

    public boolean temHabilidadeEspecial() {
        return false;
    }
}

*/

class Cobranca {
    double cobrar(@NotNull Cobravel empregado, int dias) {
        int base = empregado.getDiaria() * dias;
        if (empregado.temHabilidadeEspecial())
            return base * 1.05;
        else
            return base;
    }
}


class Empregado implements Cobravel{

    public int getDiaria() {
        return 0;
    }

    public boolean temHabilidadeEspecial() {
        return false;
    }
}

interface Cobravel {
    int getDiaria();

    boolean temHabilidadeEspecial();
}