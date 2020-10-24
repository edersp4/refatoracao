package br.com.refatoracao.organizando.dados.duplicar.dados.observado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;
import java.util.Observer;
// TODO precisava entender melhor essa refatoracao
public class DuplicarDadosObservado {
    public static void main(String[] args) {
        final JFrame janelaIntervalo = new JanelaIntervalo();
        janelaIntervalo.setBounds(1000, 1000, 1000, 1000);
        janelaIntervalo.show();

    }
}


/*
class JanelaIntervalo extends Frame {
    TextField campoInicio , campoFim , campoTamanho;

    public static void main(String[] args) {
    }

    class SymFocus extends FocusAdapter {
        public void focusLost(FocusEvent event) {
            final Object source = event.getSource();
            if (source == campoInicio)
                campoInicioPerdeuFoco(event);
            else if (source == campoFim)
                campoFimPerdeuFoco(event);
            else if (source == campoTamanho)
                campoTamanhoPerdeuFoco(event);

        }


        private void campoInicioPerdeuFoco(FocusEvent event) {
            if(naoEhInteiro(campoInicio.getText()))
                campoInicio.setText("0");
            calculaTamanho();
        }

        private void campoFimPerdeuFoco(FocusEvent event) {
            if (naoEhInteiro(campoFim.getText()))
                campoFim.setText("0");
            calculaTamanho();
        }

        private void calculaTamanho() {
            try {
                final int inicio = Integer.parseInt(campoInicio.getText());
                final int fim = Integer.parseInt(campoFim.getText());
                int tamanho = fim - inicio;
                campoTamanho.setText(String.valueOf(tamanho));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Erro: Formato Numérico não esperado");
            }
        }

        private void campoTamanhoPerdeuFoco(FocusEvent event) {
            if (naoEhInteiro(campoTamanho.getText()))
                campoTamanho.setText("0");
            calculaFim();
        }



        private void calculaFim() {

            try {
                final int inicio = Integer.parseInt(campoInicio.getText());
                final int tamanho = Integer.parseInt(campoTamanho.getText());
                final int fim = inicio + tamanho;
                campoFim.setText(String.valueOf(fim));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Erro: Formato Numérico não Esperado");
            }
        }
    }

    public boolean naoEhInteiro(String numero) {
        return numero != null && numero.matches("[0-9]*");
    }

}
*/


class JanelaIntervalo extends JFrame implements Observer{
    TextField campoInicio = new TextField("Campo Inicio"), campoFim = new TextField("Campo Fim"), campoTamanho = new TextField("Campo Tamanho");
    private Intervalo assunto;

    public JanelaIntervalo() {
        assunto = new Intervalo();
        assunto.addObserver((Observer) this);
        update(assunto, null);
        getContentPane().add(campoInicio);
        getContentPane().add(campoFim);
        getContentPane().add(campoTamanho);
    }

    @Override
    public void update(Observable observado, Object o) {
        campoFim.setText(assunto.getFim());
    }


    class SymFocus extends FocusAdapter {
        public void focusLost(FocusEvent event) {
            final Object source = event.getSource();
            if (source == campoInicio)
                campoInicioPerdeuFoco(event);
            else if (source == campoFim)
                campoFimPerdeuFoco(event);
            else if (source == campoTamanho)
                campoTamanhoPerdeuFoco(event);

        }


        private void campoInicioPerdeuFoco(FocusEvent event) {
            if(naoEhInteiro(getCampoInicio()))
                setCampoInicio("0");
            calculaTamanho();
        }

        private void campoFimPerdeuFoco(FocusEvent event) {
            setCampoFim(getCampoFim());
            if (naoEhInteiro(getCampoFim()))
                setCampoFim("0");
            calculaTamanho();
        }

        private void calculaTamanho() {
            try {
                final int inicio = Integer.parseInt(getCampoInicio());
                final int fim = Integer.parseInt(getCampoFim());
                int tamanho = fim - inicio;
                campoTamanho.setText(String.valueOf(tamanho));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Erro: Formato Numérico não esperado");
            }
        }

        private void campoTamanhoPerdeuFoco(FocusEvent event) {
            if (naoEhInteiro(getCampoTamanho()))
                setCampoTamanho("0");
            calculaFim();
        }



        private void calculaFim() {

            try {
                final int inicio = Integer.parseInt(getCampoInicio());
                final int tamanho = Integer.parseInt(getCampoTamanho());
                final int fim = inicio + tamanho;
                setCampoFim(String.valueOf(fim));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Erro: Formato Numérico não Esperado");
            }
        }
    }

    public boolean naoEhInteiro(String numero) {
        return numero != null && numero.matches("[0-9]*");
    }

    public String getCampoInicio() {
        return campoInicio.getText();
    }

    public void setCampoInicio(String campoInicio) {
        this.campoInicio.setText(campoInicio);
    }

    public String getCampoFim() {
        return assunto.getFim();
    }

    public void setCampoFim(String campoFim) {
        this.assunto.setFim(campoFim);
    }

    public String getCampoTamanho() {
        return campoTamanho.getText();
    }

    public void setCampoTamanho(String campoTamanho) {
        this.campoTamanho.setText(campoTamanho);
    }

}

class Intervalo extends Observable {
    private String fim = "0";

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
        setChanged();
        notifyObservers();
    }

}
