package br.com.refatoracao.simplificando.expressoes.condicionais.introduzir.objeto.nulo;

/**
 * @author ederson
 * project refatoracao
 * @since 16/10/2020
 */
public class IntroduzirObjetoNulo {
    public static void main(String[] args) {
/*
        final Cliente cliente = new Cliente();
        final PlanoDeCobranca planoDeCobranca;
        if (cliente == null) {
            planoDeCobranca = PlanoDeCobranca.basico();
        } else {
            planoDeCobranca = PlanoDeCobranca.getPlano();
        }

        String nome;

        if (cliente == null) {
            nome = "Inquilino";
        } else {
            cliente.getNome();
        }

        int semanaComPagamentoAtrasado;

        if (cliente == null) {
            semanaComPagamentoAtrasado = 0;
        } else {
            semanaComPagamentoAtrasado  = cliente.getHistoricoPagamento().getSemamasComPagamentosAtrazadosNoAnoPassado();
        }
*/


        final Cliente aux = new Cliente();
        aux.setPlanoDeCobranca(PlanoDeCobranca.especial());
        aux.setHistoricoPagamento(new HistoricoPagamento());
        aux.setNome("Adriano");

        final Cliente cliente = new Local(aux).getCliente();
        System.out.println("cliente.getPlanoDeCobranca() => " + cliente.getPlanoDeCobranca().getNome());


        System.out.println("nome = cliente.getNome() => " + cliente.getNome());


        System.out.println("historico pagamento => " + cliente
                .getHistoricoPagamento()
                .getSemamasComPagamentosAtrazadosNoAnoPassado());
    }

}



class Local {
    private final Cliente cliente;

    Local(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente == null ? Cliente.novoNulo() : cliente;
    }
}
/*class Local {
    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }
}*/


class Cliente {
    private PlanoDeCobranca planoDeCobranca;
    private HistoricoPagamento historicoPagamento;
    private String nome;

    public static Cliente novoNulo() {
        return new ClienteNulo();
    }

    public PlanoDeCobranca getPlanoDeCobranca() {
        return this.planoDeCobranca;
    }

    public void setPlanoDeCobranca(PlanoDeCobranca planoDeCobranca) {
        this.planoDeCobranca = planoDeCobranca;
    }

    public HistoricoPagamento getHistoricoPagamento() {
        return historicoPagamento;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isNull() {
        return true;
    }

    public void setHistoricoPagamento(HistoricoPagamento historicoPagamento) {
        this.historicoPagamento = historicoPagamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class ClienteNulo extends Cliente {
    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String getNome() {
        return "Inquilino";
    }

    @Override
    public PlanoDeCobranca getPlanoDeCobranca() {
        return PlanoDeCobranca.basico();
    }

    @Override
    public HistoricoPagamento getHistoricoPagamento() {
        return HistoricoPagamentoNulo.novoNulo();
    }
}

class PlanoDeCobranca {
    private String nome;

    public static PlanoDeCobranca basico() {
        final PlanoDeCobranca planoDeCobranca = new PlanoDeCobranca();
        planoDeCobranca.setNome("Plano Básico");
        return planoDeCobranca;
    }

    public static PlanoDeCobranca especial() {
        final PlanoDeCobranca planoDeCobranca = new PlanoDeCobranca();
        planoDeCobranca.setNome("Plano Especial");
        return planoDeCobranca;
    }

    public PlanoDeCobranca getPlano() {
        return new PlanoDeCobranca();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class HistoricoPagamento {
    public int getSemamasComPagamentosAtrazadosNoAnoPassado() {
        return 50;
    }
}

class HistoricoPagamentoNulo extends HistoricoPagamento {
    public static HistoricoPagamento novoNulo() {
        return new HistoricoPagamentoNulo();
    }

    @Override
    public int getSemamasComPagamentosAtrazadosNoAnoPassado() {
        return 0;
    }
}


/*

antes da refatoracao
class Cliente {
    private PlanoDeCobranca planoDeCobranca;
    private HistoricoPagamento historicoPagamento;
    private String nome;

    public PlanoDeCobranca getPlanoDeCobranca() {
        return this.planoDeCobranca;
    }

    public HistoricoPagamento getHistoricoPagamento() {
        return historicoPagamento;
    }

    public String getNome() {
        return this.nome;
    }
}

class PlanoDeCobranca {

    public static PlanoDeCobranca basico() {
        return new PlanoDeCobranca();
    }

    public static PlanoDeCobranca getPlano() {
        return new PlanoDeCobranca();
    }
}

class HistoricoPagamento {
    int getSemamasComPagamentosAtrazadosNoAnoPassado() {
        return 50;
    }
}*/
