package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;

public class CalculadoraDeRendimento {

    public BigDecimal calcularRendimento(BigDecimal valor, BigDecimal percentual) {
        BigDecimal rendimento = valor.multiply(percentual);
        return rendimento;
    }

}
