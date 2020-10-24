package br.com.refatoracao.organizando.dados.substituir.enumeracao.pelo.padrao.strategy.v2;

/**
 * @author ederson
 * project refatoracao
 * @since 13/10/2020
 */
public class SubstituirEnumeracaoPeloPadraoStrategy {
    public static void main(String[] args) {
        final Empregado engenheiro = new Empregado(TipoEnum.ENGENHEIRO);

        System.out.println("Engenheiro");
        System.out.println(engenheiro.quantiaAPagar());
        System.out.println();

        final Empregado vendedor = new Empregado(TipoEnum.VENDEDOR);

        System.out.println("Vendedor");
        System.out.println(vendedor.quantiaAPagar());
        System.out.println();


        final Empregado gerente = new Empregado(TipoEnum.GERENTE);

        System.out.println("Gerente");
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
    ENGENHEIRO(1){
        @Override
        double quantiaAPagar(double salarioMensal, double comissao, double bonus) {
            return salarioMensal;
        }
    } , VENDEDOR(2) {
        @Override
        double quantiaAPagar(double salarioMensal, double comissao, double bonus) {
            return salarioMensal + comissao;
        }
    }, GERENTE(3) {
        @Override
        double quantiaAPagar(double salarioMensal, double comissao, double bonus) {
            return salarioMensal + bonus;
        }
    };



    private final int codigo;


    TipoEnum(int codigo) {
        this.codigo = codigo;
    }

    abstract double quantiaAPagar(double salarioMensal , double commisao , double bonus);

    public int getCodigo() {
        return codigo;
    }
}

class Empregado {
    private double salarioMensal = 1000;
    private double comissao = 50;
    private double bonus = 100;
    private TipoEnum tipoEnum;

    public Empregado(TipoEnum tipoEnum) {
        this.tipoEnum = tipoEnum;
    }

    double quantiaAPagar(){
       return this.tipoEnum.quantiaAPagar(salarioMensal, comissao, bonus);
    }


}

