package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Conta {

    protected BigDecimal saldo = BigDecimal.ZERO;

    protected void diminuirSaldo(BigDecimal valor) throws ContaSemSaldoException {
        this.saldo = this.saldo.min(valor);
        System.out.println("Saldo atual: " + this.saldo.setScale(2, RoundingMode.HALF_DOWN));
    }

    protected Boolean verificarSeValorEstaDisponivel(BigDecimal valor) {
        //CompareTo retorno três valores -1, 0 e 1
        // Se for -1 o valor da esquerda é menor que o da direita
        // Se for 0 os valores são iguais
        // Se for 1 o valor da direito é menor que o da esquerda
        Boolean temSaldoParaOperacao = false;
        if (saldo.compareTo(valor) >= 0) {
            temSaldoParaOperacao = true;
        }
        return temSaldoParaOperacao;
    }

    protected void aumentarSaldo(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
        System.out.println("Saldo atual: " + this.saldo.setScale(2, RoundingMode.HALF_DOWN));
    }

}
