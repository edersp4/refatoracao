package br.com.refatoracao.organizando.dados.substituir.subclasse.por.campos;

/**
 * @author ederson
 * project refatoracao
 * @since 14/10/2020
 */
public class SubstituirSubclassePorCampos {

    public static void main(String[] args) {
        Pessoa kent = new Pessoa(true, 'M');
        Pessoa elaine = new Pessoa(false, 'F');

        //
        System.out.println("masculino");
        System.out.println(kent.ehMasculino());
        System.out.println(kent.getCodigo());

        System.out.println("feminino");
        System.out.println(elaine.ehMasculino());
        System.out.println(elaine.getCodigo());

    }
}
/*
Antes da refatoracao
abstract class Pessoa {
    abstract boolean ehMasculino();

    abstract char lerCodigo();
}

class Masculino extends Pessoa {
    @Override
    boolean ehMasculino() {
        return true;
    }

    @Override
    char lerCodigo() {
        return 'M';
    }
}

class Feminino extends Pessoa {

    @Override
    boolean ehMasculino() {
        return false;
    }

    @Override
    char lerCodigo() {
        return 'F';
    }
}
*/

class Pessoa {

    private boolean ehMasculino;
    private char codigo;

    protected Pessoa(boolean ehMasculino, char codigo) {
        this.ehMasculino = ehMasculino;
        this.codigo = codigo;
    }

    boolean ehMasculino() {
        return this.ehMasculino;
    }

    char getCodigo() {
        return this.codigo;
    }

}


