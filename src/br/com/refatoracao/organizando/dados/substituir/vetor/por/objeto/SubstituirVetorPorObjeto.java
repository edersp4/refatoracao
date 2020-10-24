package br.com.refatoracao.organizando.dados.substituir.vetor.por.objeto;

public class SubstituirVetorPorObjeto {
}
/*
Antes da Refatoracao
class Jogo {
    String[] disputa = new String[3];

    public void armazenar() {
        disputa[0] = "Santos";
        disputa[1] = "15";
        disputa[2] = "3";

        String nome = disputa[0];
        String vitorias = disputa[1];
        String derrotas = disputa[2];

    }
}
*/
class Jogo {
    String[] disputa = new String[3];

    public void armazenar() {
        Disputa disputa = new Disputa();
        disputa.setNome("Santos");
        disputa.setVitoria("15");

        disputa.setDerrota("3");

        String nome = disputa.getNome();
        Integer vitorias = disputa.getVitoria();
        Integer derrotas = disputa.getDerrota();

    }
}

class Disputa {
    private String nome;
    private Integer vitoria;
    private Integer derrota;


    public String getNome() {
        return nome;
    }

    public Integer getVitoria() {
        return vitoria;
    }

    public Integer getDerrota() {
        return derrota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVitoria(String vitoria) {
        this.vitoria = Integer.valueOf(vitoria);
    }

    public void setDerrota(String derrota) {
        this.derrota = Integer.valueOf(derrota);
    }
}