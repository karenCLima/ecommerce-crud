package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;

public class ContaCorrente extends Conta implements ISaque, IDeposito {

    @Override
    public void sacar(BigDecimal valor) {
        if (verificarSeValorEstaDisponivel(valor)) {
            diminuirSaldo(valor);
        } else {
            throw new ContaSemSaldoException();
        }
    }

    @Override
    public void depositar(BigDecimal valor) {
        aumentarSaldo(valor);
    }

}
