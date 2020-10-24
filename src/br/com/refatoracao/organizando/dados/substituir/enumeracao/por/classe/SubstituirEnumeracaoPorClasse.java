package br.com.refatoracao.organizando.dados.substituir.enumeracao.por.classe;

public class SubstituirEnumeracaoPorClasse {

    public static void main(String[] args) {
        final Pessoa pessoa = new Pessoa(GrupoSanguinioClasse.AB);

        pessoa.setGrupoSanguinio(GrupoSanguinioClasse.AB);
    }

}

/*
antes da refatoracao
class Pessoa{
    private GrupoSanguinio grupoSanguinio;

    public Pessoa(GrupoSanguinio grupoSanguinio) {
        this.grupoSanguinio = grupoSanguinio;
    }

    public GrupoSanguinio getGrupoSanguinio() {
        return grupoSanguinio;
    }

    public void setCodigoGrupoSanguinio(GrupoSanguinio grupoSanguinio) {
        this.grupoSanguinio = grupoSanguinio;
    }
}

enum GrupoSanguinio {
   O , A , B, AB
}*/

class Pessoa {
    private GrupoSanguinioClasse grupoSanguinio;

    public Pessoa(GrupoSanguinioClasse grupoSanguinio) {
        this.grupoSanguinio = grupoSanguinio;
    }

    public void setGrupoSanguinio(GrupoSanguinioClasse grupoSanguinioClasse) {
        this.grupoSanguinio = grupoSanguinioClasse;
    }

    public int getCodigoDoGrupoSanguinio() {
        return this.grupoSanguinio.getCodigo();
    }

    public GrupoSanguinioClasse getGrupoSanguinio() {
        return this.grupoSanguinio;
    }
}

enum GrupoSanguinio {
    O, A, B, AB
}


class GrupoSanguinioClasse {
    public static final GrupoSanguinioClasse O = new GrupoSanguinioClasse(0);
    public static final GrupoSanguinioClasse A = new GrupoSanguinioClasse(1);
    public static final GrupoSanguinioClasse B = new GrupoSanguinioClasse(2);
    public static final GrupoSanguinioClasse AB = new GrupoSanguinioClasse(3);
    private static final GrupoSanguinioClasse[] valores = {O, A, B, AB};

    private final int codigo;

    public GrupoSanguinioClasse(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static GrupoSanguinioClasse[] getValores() {
        return valores;
    }
}