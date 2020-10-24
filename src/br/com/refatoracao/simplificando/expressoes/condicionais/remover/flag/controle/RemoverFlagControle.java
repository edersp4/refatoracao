package br.com.refatoracao.simplificando.expressoes.condicionais.remover.flag.controle;

/**
 * @author ederson
 * project refatoracao
 * @since 15/10/2020
 */
public class RemoverFlagControle {
}

/*
antes da refatoracao
class Controle {
    void verificarSeguranca(String[] pessoas) {
        boolean encontrei = false;
        for (int count = 0; count < pessoas.length; count++) {
            if (!encontrei) {
                if (pessoas[count].equals("Don")) {
                    enviarAlerta();
                    encontrei = true;
                }
                if (pessoas[count].equals("Jhon")) {
                    enviarAlerta();
                    encontrei = true;
                }
            }
        }
    }

     String verificarSegurancaComReturn(String[] pessoas) {
        String encontrei = "";
        for (int count = 0; count < pessoas.length; count++) {
            if (encontrei.equals("")) {
                if (pessoas[count].equals("Don")) {
                    enviarAlerta();
                    encontrei = "Don";
                }
                if (pessoas[count].equals("Jhon")) {
                    enviarAlerta();
                    encontrei = "Jhon";
                }
            }
        }
        return encontrei;
    }

    private void enviarAlerta() {

    }
}
*/
class Controle {
    void verificarSeguranca(String[] pessoas) {
        boolean encontrei = false;
        for (int count = 0; count < pessoas.length; count++) {
            if (!encontrei) {
                if (pessoas[count].equals("Don")) {
                    enviarAlerta();
                    break;
                }
                if (pessoas[count].equals("Jhon")) {
                    enviarAlerta();
                    break;
                }
            }
        }
    }

    String verificarSegurancaComReturn(String[] pessoas) {
        String encontrei = "";
        return encontreiInframe(pessoas);
    }

    private String encontreiInframe(String[] pessoas) {
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

    }
}