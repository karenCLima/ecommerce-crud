package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;

public class ContaEletronica extends Conta implements IPix, IRendimentoDiario {

    private CalculadoraDeRendimento calculadora = new CalculadoraDeRendimento();

    @Override
    public void receber(BigDecimal valor) {
        aumentarSaldo(valor);
    }

    @Override
    public void enviar(BigDecimal valor) {
        if (verificarSeValorEstaDisponivel(valor)) {
            diminuirSaldo(valor);
        } else {
            throw new ContaSemSaldoException();
        }
    }

    @Override
    public BigDecimal calculo() {
        return calculadora.calcularRendimento(saldo, BigDecimal.valueOf(0.05));
    }

    @Override
    public void incrementaSaldo(BigDecimal valor) {
        aumentarSaldo(valor);
    }

}
