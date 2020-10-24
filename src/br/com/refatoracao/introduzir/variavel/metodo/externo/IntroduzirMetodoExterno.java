package br.com.refatoracao.introduzir.variavel.metodo.externo;

import java.util.Date;

/**
 * Motivação quando se precisa ter um método que uma classe que não se pode
 * modificar não tem e se reutiliza muito
 */
public class IntroduzirMetodoExterno {
}

/*Antes da refatoração
class MetodoExterno {
    public void novaData(Date finalAnterior) {
        Date novoInicio = new Date(finalAnterior.getYear(), finalAnterior.getMonth(), finalAnterior.getDate() + 1);
    }
}
*/


class MetodoExterno {
    public void novaData(Date finalAnterior) {
        Date novoInicio = proximoDia(finalAnterior);
    }


    private static Date proximoDia(Date arg) {
        // método externo, deveria estar na classe Date
        return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
    }
}
