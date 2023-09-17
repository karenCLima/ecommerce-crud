package br.ada.customer.crud.examples.banco;

import java.math.BigDecimal;

public class MainConta {

    public static void main(String[] args) {
        ContaPoupanca conta = new ContaPoupanca();
        conta.depositar(BigDecimal.TEN);
        calcularRendimento(conta);
    }

    public static void calcularRendimento(IRendimentoDiario rendimento) {
        int dias = 30;
        while (dias > 0) {
            BigDecimal valorDoDia = rendimento.calculo();
            rendimento.incrementaSaldo(valorDoDia);
            --dias;
        }
    }
}
