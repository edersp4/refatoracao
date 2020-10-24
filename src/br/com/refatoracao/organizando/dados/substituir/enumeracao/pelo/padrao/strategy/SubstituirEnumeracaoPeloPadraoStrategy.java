package br.com.refatoracao.organizando.dados.substituir.enumeracao.pelo.padrao.strategy;

/**
 * @author ederson
 * project refatoracao
 * @since 13/10/2020
 */
public class SubstituirEnumeracaoPeloPadraoStrategy {
    public static void main(String[] args) {
        final Empregado engenheiro = new Empregado(new Engenheiro());

        System.out.println("Engenheiro");
        System.out.println(engenheiro.getTipoEmpregado());
        System.out.println(engenheiro.getTipoEmpregado().getCodigo());
        System.out.println(engenheiro.quantiaAPagar());
        System.out.println();

        final Empregado vendedor = new Empregado(new Vendedor());

        System.out.println("Vendedor");
        System.out.println(vendedor.getTipoEmpregado());
        System.out.println(vendedor.getTipoEmpregado().getCodigo());
        System.out.println(vendedor.quantiaAPagar());
        System.out.println();


        final Empregado gerente = new Empregado(new Gerente());

        System.out.println("Gerente");
        System.out.println(gerente.getTipoEmpregado());
        System.out.println(gerente.getTipoEmpregado().getCodigo());
        System.out.println(gerente.quantiaAPagar());
        System.out.println();

    }
}

/*

Antes da refatoracao
enum TipoEnum {
    ENGENHEIRO(1) , VENDEDOR(2) , GERENTE(3);


    private int codigo;
    TipoEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}

class Empregado {
    private TipoEnum tipoEnum;
    private double salarioMensal;
    private double comissao;
    private double bonus;

    Empregado(TipoEnum tipoEnum) {
        this.tipoEnum = tipoEnum;
    }

    double quantiaAPagar(){
        switch (tipoEnum){
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

}
*/


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
