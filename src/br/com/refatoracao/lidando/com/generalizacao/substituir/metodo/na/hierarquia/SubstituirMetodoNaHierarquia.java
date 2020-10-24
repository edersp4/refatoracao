package br.com.refatoracao.lidando.com.generalizacao.substituir.metodo.na.hierarquia;

import java.util.Date;

/**
 * @author ederson
 * project refatoracao
 * @since 24/10/2020
 */
public class SubstituirMetodoNaHierarquia {
}
/*

class Cliente {
    public void adicionarConta(Date data, double quantidade) {

    }

    public Date dataUltimaCobranca() {
        return new Date();
    }

}

class ClienteNormal extends Cliente{

    public void criarConta(Date date) {
        double quantiaAcobrar = cobrarPor(dataUltimaCobranca(), date);
        adicionarConta(date, quantiaAcobrar);
    }

    public double cobrarPor(Date inicio, Date fim) {
        return 0;
    }
}

class ClientePreferencial extends Cliente{
    public void criarConta(Date date) {
        double quantiaAcobrar = cobrarPor(dataUltimaCobranca(), date);
        adicionarConta(date, quantiaAcobrar);
    }

    public double cobrarPor(Date inicio, Date fim) {
        return 50;
    }
}*/



abstract class Cliente {
    public void adicionarConta(Date data, double quantidade) {

    }

    public Date dataUltimaCobranca() {
        return new Date();
    }

    public void criarConta(Date date) {
        double quantiaAcobrar = cobrarPor(dataUltimaCobranca(), date);
        adicionarConta(date, quantiaAcobrar);
    }

    public abstract double cobrarPor(Date inicio, Date fim);
}

class ClienteNormal extends Cliente{

    @Override
    public double cobrarPor(Date inicio, Date fim) {
        return 0;
    }
}

class ClientePreferencial extends Cliente{

    @Override
    public double cobrarPor(Date inicio, Date fim) {
        return 50;
    }
}