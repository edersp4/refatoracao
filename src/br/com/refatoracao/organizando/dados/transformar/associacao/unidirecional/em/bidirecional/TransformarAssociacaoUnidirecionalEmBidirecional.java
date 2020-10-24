package br.com.refatoracao.organizando.dados.transformar.associacao.unidirecional.em.bidirecional;

import java.util.HashSet;
import java.util.Set;

public class TransformarAssociacaoUnidirecionalEmBidirecional {

}
/*

Antes da refatoracao
class Pedido {
    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

class Cliente {
    private Set<Pedido> pedidos = new HashSet<>();

    Set getPedidos() {
        return pedidos;
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
            this.cliente
                    .getPedidos()
                    .remove(this);

        this.cliente = cliente;
        if (cliente != null)
            this.cliente
                    .getPedidos()
                    .add(this);
    }
}

class Cliente {
    private Set<Pedido> pedidos = new HashSet<>();

    Set getPedidos() {
        return pedidos;
    }
}


