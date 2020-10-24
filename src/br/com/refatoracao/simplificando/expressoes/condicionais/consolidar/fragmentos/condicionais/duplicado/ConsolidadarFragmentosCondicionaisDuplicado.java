package br.com.refatoracao.simplificando.expressoes.condicionais.consolidar.fragmentos.condicionais.duplicado;

/**
 * @author ederson
 * project refatoracao
 * @since 15/10/2020
 */
public class ConsolidadarFragmentosCondicionaisDuplicado {
}
/*
antes da refatoracao
class Negocio {

    private void negociavel() {
        double total = 0;
        final double preco = 50;

        if (ehNegocioEspecial()) {
            total = preco * 0.95;
            enviar();
        } else {
            total = preco * 0.98;
            enviar();
        }
    }

    private void enviar() {

    }

    private boolean ehNegocioEspecial() {
        return false;
    }
}*/


class Negocio {

    private void negociavel() {
        double total = 0;
        final double preco = 50;

        if (ehNegocioEspecial()) {
            total = preco * 0.95;
        } else {
            total = preco * 0.98;
        }
        enviar();
    }

    private void enviar() {

    }

    private boolean ehNegocioEspecial() {
        return false;
    }
}
