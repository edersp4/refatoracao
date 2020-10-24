package br.com.refatoracao.organizando.dados.substituir.enumeracao.por.subclasse;

/**
 * @author ederson
 * project refatoracao
 * @since 13/10/2020
 */
public class SubstituirEnumeracaoPorSubclasse {

    public static void main(String[] args) {
        final Empregado empregado = Empregado.create(TipoEnum.GERENTE);

        if(empregado instanceof Gerente) {
            System.out.println(" Ele é um gerente");
            System.out.println(empregado.getCodigo());
        }
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

    Empregado(TipoEnum tipoEnum) {
        this.tipoEnum = tipoEnum;
    }


}
*/
enum TipoEnum {
    ENGENHEIRO, VENDEDOR , GERENTE

}

abstract class Empregado {

    static Empregado create(TipoEnum tipoEnum) {
        switch (tipoEnum) {
            case ENGENHEIRO:
                return new Engenheiro();
            case VENDEDOR:
                return new Vendedor();
            case GERENTE:
                return new Gerente();
            default:
                throw new IllegalArgumentException("Valor inválido para a enumeracao");
        }
    }

    public abstract TipoEnum getTipoEnum();

    public abstract int getCodigo() ;
}

class Engenheiro extends Empregado {

    @Override
    public TipoEnum getTipoEnum(){
        return TipoEnum.ENGENHEIRO;
    }

    @Override
    public int getCodigo() {
        return 1;
    }
}

class Vendedor extends Empregado {
    @Override
    public TipoEnum getTipoEnum() {
        return TipoEnum.VENDEDOR;
    }

    @Override
    public int getCodigo() {
        return 2;
    }
}

class Gerente extends Empregado {
    @Override
    public TipoEnum getTipoEnum() {
        return TipoEnum.GERENTE;
    }

    @Override
    public int getCodigo() {
        return 3;
    }
}