package br.com.refatoracao.simplificando.expressoes.condicionais.substituir.comando.condicional.por.polimorfismo;

/**
 * @author ederson
 * project refatoracao
 * @since 16/10/2020
 */
public class SubstituirComandoCondicionalPorPolimorfismo {
    public static void main(String[] args) {
        final Empregado engenheiro = new Empregado(TipoEmpregado.ENGENHEIRO);

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
        System.out.println();

    }
}


/*
antes da refatoracao
enum TipoEnum {
    ENGENHEIRO(1) , VENDEDOR(2) , GERENTE(3);


    private final int codigo;

    TipoEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}

class Empregado {
    private TipoEmpregado tipoEmpregado;
    private double salarioMensal = 1000;
    private double comissao = 50;
    private double bonus = 100;

    Empregado(TipoEmpregado tipoEmpregado) {
        this.tipoEmpregado = tipoEmpregado;
    }


    double quantiaAPagar(){
        switch (getTipoEmpregado()){
            case ENGENHEIRO:
                return salarioMensal;
            case GERENTE:
                return salarioMensal + comissao;
            case VENDEDOR:
                return salarioMensal + bonus;
            default:
                throw new RuntimeException(" Tipo Incorreto de funcionário");
        }

    }

    public TipoEnum getTipoEmpregado() {
        return tipoEmpregado.getTipoEnum();
    }

}

abstract class TipoEmpregado {

    public abstract TipoEnum getTipoEnum();

    public abstract int getCodigo();

    public static TipoEmpregado novoTipo(TipoEnum tipoEnum) {
        switch (tipoEnum) {
            case ENGENHEIRO:
                return new Engenheiro();
            case VENDEDOR:
                return new Vendedor();
            case GERENTE:
                return new Gerente();
            default:
                throw new IllegalArgumentException("Valor inválido");
        }

    }
}

class Engenheiro extends TipoEmpregado {

    @Override
    public TipoEnum getTipoEnum() {
        return TipoEnum.ENGENHEIRO;
    }

    @Override
    public int getCodigo() {
        return TipoEnum.ENGENHEIRO.getCodigo();
    }
}

class Gerente extends TipoEmpregado {

    @Override
    public TipoEnum getTipoEnum() {
        return TipoEnum.GERENTE;
    }

    @Override
    public int getCodigo() {
        return TipoEnum.GERENTE.getCodigo();
    }
}

class Vendedor extends TipoEmpregado {

    @Override
    public TipoEnum getTipoEnum() {
        return TipoEnum.VENDEDOR;
    }

    @Override
    public int getCodigo() {
        return TipoEnum.VENDEDOR.getCodigo();
    }
}


 */

class Empregado {
    public static final double SALARIO_MENSAL = 1000;
    public static final double COMISSAO = 50.0;
    public static final double BONUS = 100;
    private final TipoEmpregado tipoEmpregado;

    Empregado(TipoEmpregado tipoEmpregado) {
        this.tipoEmpregado = tipoEmpregado;
    }

    double quantiaAPagar() {
        return this.tipoEmpregado.quantiaAPagar();
    }

}

interface TipoEmpregado {
    TipoEmpregado ENGENHEIRO = new Engenheiro();
    TipoEmpregado GERENTE = new Gerente();
    TipoEmpregado VENDEDOR = new Vendedor();

    double quantiaAPagar();
}

class Engenheiro implements TipoEmpregado {

    @Override
    public double quantiaAPagar() {
        return Empregado.SALARIO_MENSAL;
    }
}

class Gerente implements TipoEmpregado {

    @Override
    public double quantiaAPagar() {
        return Empregado.SALARIO_MENSAL + Empregado.COMISSAO;
    }
}

class Vendedor implements TipoEmpregado {

    @Override
    public double quantiaAPagar() {
        return Empregado.SALARIO_MENSAL + Empregado.BONUS;
    }
}
