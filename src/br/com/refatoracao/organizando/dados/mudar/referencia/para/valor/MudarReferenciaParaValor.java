package br.com.refatoracao.organizando.dados.mudar.referencia.para.valor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MudarReferenciaParaValor {
    public static void main(String[] args) {
        final MoedaCorrente usd = new MoedaCorrente("USD");
        System.out.println("usd.getCodigo() = " + usd.getCodigo());
    }
}

/*
Antes da refatoracao
class MoedaCorrente {

    private static final Map<String, MoedaCorrente> map;

    static {
        map = new HashMap<>();
        new MoedaCorrente("USD").armazenar();
        new MoedaCorrente("R$").armazenar();
        new MoedaCorrente("$").armazenar();
    }

    private final String codigo;

    private MoedaCorrente(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static MoedaCorrente create(String codigo) {
        return map.get(codigo);
    }

    private void armazenar() {
        map.put(this.getCodigo(), this);
    }




}

   */


class MoedaCorrente {

    private final String codigo;

    public MoedaCorrente(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MoedaCorrente that = (MoedaCorrente) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}