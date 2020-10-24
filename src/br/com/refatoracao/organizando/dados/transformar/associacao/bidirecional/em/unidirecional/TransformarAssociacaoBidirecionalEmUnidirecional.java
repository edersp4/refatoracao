package br.com.refatoracao.organizando.dados.transformar.associacao.bidirecional.em.unidirecional;

import java.util.HashSet;
import java.util.Set;

public class TransformarAssociacaoBidirecionalEmUnidirecional {
}
/*

Antes da refatoracao

class Pedido {
    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null)
            this.cliente
                    .getPedidos()
                    .remove(this);

        this.cliente = cliente;
        if (cliente != null)
            this.cliente
                    .getPedidos()
                    .add(this);
    }

    double getPrecoComDesconto() {
        return getPrecoBruto() * (1 - cliente.getDesconto());
    }

    private double getPrecoBruto() {
        return 0;
    }

}

class Cliente {
    private Set<Pedido> pedidos = new HashSet<>();

    Set getPedidos() {
        return pedidos;
    }

    public int getDesconto() {
        return 0;
    }
}
*/

class Pedido {
    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null)
            this.cliente.getPedidos().remove(this);

        this.cliente = cliente;
        if (cliente != null)
            this.cliente.getPedidos().add(this);
    }

    double getPrecoComDesconto(Cliente cliente) {
        return getPrecoBruto() * (1 - cliente.getDesconto());
    }

    private double getPrecoBruto() {
        return 0;
    }



}

class Cliente {
    private Set<Pedido> pedidos = new HashSet<>();

    Set getPedidos() {
        return pedidos;
    }

    public int getDesconto() {
        return 0;
    }

    double getPrecoDe(Pedido pedido) throws Throwable {
        if(pedidos.contains(pedido))
            return pedido.getPrecoComDesconto(this);
        else {
            throw new Throwable("Não existe o pedido");
        }
    }
}

