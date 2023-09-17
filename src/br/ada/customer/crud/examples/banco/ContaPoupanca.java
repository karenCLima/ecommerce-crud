package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta implements ISaque, IDeposito, IRendimentoDiario {

    private CalculadoraDeRendimento calculadora = new CalculadoraDeRendimento();

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

    @Override
    public BigDecimal calculo() {
        return calculadora.calcularRendimento(saldo, BigDecimal.valueOf(0.003));
    }

    @Override
    public void incrementaSaldo(BigDecimal valor) {
        aumentarSaldo(valor);
    }

}