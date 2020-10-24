package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.substituir.parametros.por.metodos.explicitos;

/**
 * @author ederson
 * project refatoracao
 * @since 19/10/2020
 */
public class SubstituirParametrosPorMetodosExplicitos {
    public static void main(String[] args) {
      /*  final Empregado engenheiro = new Empregado(TipoEmpregado.ENGENHEIRO);

        System.out.println("Engenheiro");
        System.out.println(engenheiro.quantiaAPagar());
        System.out.println();

        final Empregado vendedor = new Empregado(TipoEmpregado.VENDEDOR);

        System.out.println("Vendedor");
        System.out.println(vendedor.quantiaAPagar());
        System.out.println();


        final Empregado gerente = new Empregado(TipoEmpregado.GERENTE);

        System.out.println("Gerente");
        System.out.println(gerente.quantiaAPagar());
        System.out.println();*/

        final Empregado engenheiro = new Empregado(TipoEmpregado.criarEngenheiro());

        System.out.println("Engenheiro");
        System.out.println(engenheiro.quantiaAPagar());
        System.out.println();

        final Empregado vendedor = new Empregado(TipoEmpregado.criarVendedor());

        System.out.println("Vendedor");
        System.out.println(vendedor.quantiaAPagar());
        System.out.println();


        final Empregado gerente = new Empregado(TipoEmpregado.criarGerente());

        System.out.println("Gerente");
        System.out.println(gerente.quantiaAPagar());
        System.out.println();

    }

}

class Empregado {
    public static final double SALARIO_MENSAL = 1000;
    public static final double COMISSAO = 50.0;
    public static final double BONUS = 100;
    private final TipoEmpregado tipoEmpregado;

    Empregado(TipoEmpregado empregado) {
        tipoEmpregado = empregado;
    }

    double quantiaAPagar() {
        return this.tipoEmpregado.quantiaAPagar();
    }

}
/*

abstract class TipoEmpregado {
    public static final int ENGENHEIRO = 0;
    public static final int GERENTE = 1;
    public static final int VENDEDOR = 2;

    public static TipoEmpregado criar(int tipo) {
        switch (tipo) {
            case ENGENHEIRO:
                return new Engenheiro();
            case GERENTE:
                return new Gerente();
            case VENDEDOR:
                return new Vendedor();
            default:
                throw new IllegalArgumentException("Tipo de Empregado incorreto");
        }

    }

    public abstract double quantiaAPagar();
}
*/


abstract class TipoEmpregado {

    static Vendedor criarVendedor() {
        return new Vendedor();
    }

    static Gerente criarGerente() {
        return new Gerente();
    }

    static Engenheiro criarEngenheiro() {
        return new Engenheiro();
    }

    public abstract double quantiaAPagar();
}


class Engenheiro extends TipoEmpregado {

    @Override
    public double quantiaAPagar() {
        return Empregado.SALARIO_MENSAL;
    }
}

class Gerente extends TipoEmpregado {

    @Override
    public double quantiaAPagar() {
        return Empregado.SALARIO_MENSAL + Empregado.COMISSAO;
    }
}

class Vendedor extends TipoEmpregado {

    @Override
    public double quantiaAPagar() {
        return Empregado.SALARIO_MENSAL + Empregado.BONUS;
    }
}

