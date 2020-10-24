package br.com.refatoracao.organizando.dados.substituir.atributo.por.objeto;

import java.util.Collection;
import java.util.Iterator;

public class SubstituirAtributoPorObjeto {

}
/*
Antes da refatoracao
class Pedido {
    private String cliente;
    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    private static int numeroDePedidosPara(Collection pedidos, String cliente) {
        int resultado = 0;
        Iterator inter = pedidos.iterator();
        while (inter.hasNext()) {
            final Pedido pedido = (Pedido) inter.next();
            if (pedido.getCliente().equals(cliente))
                resultado++;


        }
        return resultado;
    }

}

*/

class Pedido {
    private Cliente cliente;
    public Pedido(String cliente) {
        this.cliente = new Cliente(cliente);
    }

    private static int numeroDePedidosPara(Collection pedidos, String nome) {
        int resultado = 0;
        Iterator inter = pedidos.iterator();
        while (inter.hasNext()) {
            final Pedido pedido = (Pedido) inter.next();
            if (pedido.getNome().equals(nome))
                resultado++;


        }
        return resultado;
    }

    public String getNome() {
        return cliente.getNome();
    }

    public void setNome(String cliente) {
        this.cliente = new Cliente(cliente);
    }

}

class Cliente {
    private final String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}