package br.com.refatoracao.tornando.mais.simples.chamadas.substituir.construtor.por.metodo.fabrica;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ederson
 * project refatoracao
 * @since 22/10/2020
 */
public class SubstituirConstrutorPorMetodoFabrica {
    public static void main(String[] args) {
        Empregado eng = Empregado.criar("Engenheiro");
        System.out.println(eng);

        Pessoa kent = Pessoa.criarMasculino();
    }
}
/*

class Empregado {

    private int tipo;
    public static final int ENGENHEIRO = 0;
    public static final int VENDEDOR = 1;
    public static final int GERENTE = 2;


    public Empregado(int tipo) {
        this.tipo = tipo;
    }

    public static Empregado criar(int tipo) {
        return new Empregado(tipo);
    }
}

class Cliente {
    public void getEmpregado() {
        Empregado eng = new Empregado(Empregado.ENGENHEIRO);
    }
}*/
// Exemplo com String

class Empregado {

    private int tipo;
    public static final int ENGENHEIRO = 0;
    public static final int VENDEDOR = 1;
    public static final int GERENTE = 2;


    public static Empregado criar(int tipo) {
        switch (tipo) {
            case ENGENHEIRO:
                return criar("Engenheiro");
            case VENDEDOR:
                return criar("Vendedor");
            case GERENTE:
                return criar("Gerente");
            default:
                throw new IllegalArgumentException("Não existe esse tipo de empregado");
        }
    }

    public static Empregado criar(String nome) {
        try {
            return (Empregado) Class
                    .forName(nome)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Não foi possivel criar o " + nome);
    }
}

class Cliente {
    public void getEmpregado() {
        Empregado eng = Empregado.criar("Engenheiro");
    }
}

class Engenheiro extends Empregado {

}

class Vendedor extends Empregado {

}
class Gerente extends Empregado {

}
// ------------------------------------ Exemplo com métodos explicitos -----------------------------------------------

class Pessoa {
    static Pessoa criarMasculino() {
        return new Masculino();
    }

    static Pessoa criarFeminino() {
        return new Feminino();
    }
}

class Masculino extends Pessoa {

}

class Feminino extends Pessoa {
}
