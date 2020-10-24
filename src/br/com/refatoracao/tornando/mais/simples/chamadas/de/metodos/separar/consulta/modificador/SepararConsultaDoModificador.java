package br.com.refatoracao.tornando.mais.simples.chamadas.de.metodos.separar.consulta.modificador;

/**
 * @author ederson
 * project refatoracao
 * @since 19/10/2020
 */
public class SepararConsultaDoModificador {

}

/*
antes da refatoracao
class Vilao {
    public String encontreiVilao(String[] pessoas) {
        for (int count = 0; count < pessoas.length; count++) {
            if (pessoas[count].equals("Don")) {
                enviarAlerta();
                return "Don";
            }
            if (pessoas[count].equals("Jhon")) {
                enviarAlerta();
                return "Jhon";
            }

        }

        return "";
    }

    private void enviarAlerta() {
        //Faz envio do Alerta
        System.out.println("enviei um alerta");
    }

    public void verificarSeguranca(String[] pessoas) {
        String encontrei = encontreiVilao(pessoas);
        algumOutroCodigo(encontrei);
    }

    private void algumOutroCodigo(String encontrei) {
        System.out.println(encontrei);
    }
}*/


class Vilao {
    public void enviarAlerta(String[] pessoas) {
        if (!encontreiPessoa(pessoas).equals("")) {
            alerta();
        }
    }


    public String encontreiPessoa(String[] pessoas) {
        for (int count = 0; count < pessoas.length; count++) {
            if (pessoas[count].equals("Don")) {
                alerta();
                return "Don";
            }
            if (pessoas[count].equals("Jhon")) {
                alerta();
                return "Jhon";
            }

        }
        return "";
    }

    private void alerta() {
        //Faz envio do Alerta
        System.out.println("enviei um alerta");
    }

    public void verificarSeguranca(String[] pessoas) {
        String encontrei = encontreiPessoa(pessoas);;
        enviarAlerta(pessoas);
        algumOutroCodigo(encontrei);
    }

    private void algumOutroCodigo(String encontrei) {
        System.out.println(encontrei);
    }
}