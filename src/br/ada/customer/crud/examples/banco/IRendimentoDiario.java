package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;

public interface IRendimentoDiario {

    BigDecimal calculo();

    void incrementaSaldo(BigDecimal valor);

}
