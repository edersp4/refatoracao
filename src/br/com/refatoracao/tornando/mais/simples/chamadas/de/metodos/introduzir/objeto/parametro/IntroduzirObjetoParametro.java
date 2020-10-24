package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.introduzir.objeto.parametro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ederson
 * project refatoracao
 * @since 21/10/2020
 */
public class IntroduzirObjetoParametro {
}

class Entrada {
    private final double valor;
    private final Date dataCobranca;

    public Entrada(double valor, Date dataCobranca) {
        this.valor = valor;
        this.dataCobranca = dataCobranca;
    }

    public double getValor() {
        return valor;
    }

    public Date getDataCobranca() {
        return dataCobranca;
    }
}

class Conta {
    private final List<Entrada> entradasList = new ArrayList<>();
    double getFluxoEntre(FaixaData faixaData) {
        double resultado = 0;
        final Entrada entrada = new Entrada(5000.0, new Date());
        final Entrada entrada1 = new Entrada(10000, new Date());
        final List<Entrada> entradas = List.of(entrada, entrada1);

        for (Entrada entr : entradas) {
            if (faixaData.isInclui(entr)) {
                resultado += entr.getValor();
            }
        }

        return resultado;
    }

}

class Cliente {
    private final Conta conta;

    Cliente(Conta conta) {
        this.conta = conta;
    }

    void getValorDoFluxo() {
        conta.getFluxoEntre(new FaixaData(new Date(), new Date()));
    }
}

class FaixaData {
    private final Date inicio;
    private final Date fim;

    FaixaData(Date inicio, Date fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFim() {
        return fim;
    }

    boolean isInclui(Entrada entr) {
        return entr.getDataCobranca()
                .equals(getInicio())
                ||
                entr
                        .getDataCobranca()
                        .equals(getFim())
                ||
                entr
                        .getDataCobranca()
                        .after(getFim())
                ||
                (entr
                        .getDataCobranca()
                        .after(getInicio()) && entr
                        .getDataCobranca()
                        .before(getFim()));
    }
}

















