package br.com.refatoracao.organizando.dados.mudar.valor.para.referencia;

import java.util.*;

public class MudarValorParaReferencia {
}

/*
Antes da refatoracao
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
            if (pedido.getNomeCliente().equals(nome))
                resultado++;


        }
        return resultado;
    }

    public String getNomeCliente() {
        return cliente.getNomeCliente();
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

    public String getNomeCliente() {
        return nome;
    }
}
*/
class Pedido {
    private Cliente cliente;
    public Pedido(String nomeCliente) {
        this.cliente = Cliente.create(nomeCliente);
    }

    private static int numeroDePedidosPara(Collection pedidos, String nome) {
        int resultado = 0;
        for (Pedido pedido : (Iterable<Pedido>) pedidos) {

            if (pedido.getNomeCliente().equals(nome))
                resultado++;

        }
        return resultado;
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }

    public void setNome(String nomeCliente) {
        this.cliente = Cliente.create(nomeCliente);
    }

}

class Cliente {
    private static final Map<String, Cliente> map = new HashMap();
    private final String nome;

    static {
        carregarClientes();
    }

    private Cliente(String nome) {
        this.nome = nome;
    }

    public static Cliente create(String nome) {
        return map.get(nome);
    }

    static void carregarClientes() {
        new Cliente("Lemon Cara Hire").armazenar();
        new Cliente("Associate Coffee Machines").armazenar();
        new Cliente("Bilston Gasworks").armazenar();
    }

    private void armazenar() {
        map.put(this.getNome(), this);
    }

    public String getNome() {
        return nome;
    }
}