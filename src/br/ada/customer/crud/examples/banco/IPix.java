package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;

public interface IPix {

    void receber(BigDecimal valor);

    void enviar(BigDecimal valor);

}
