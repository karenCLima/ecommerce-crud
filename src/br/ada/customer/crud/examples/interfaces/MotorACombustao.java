package br.ada.customer.crud.examples.interfaces;

public class MotorACombustao implements MotorLigavel, MotorHP, MotorDesligavel {

    @Override
    public void ligar() {
        System.out.println("Ligando motor....");
    }

    @Override
    public void desligar() {
        System.out.println("Desligando motor....");
    }

    @Override
    public void gerarForca() {
        System.out.println("Gerando força....");
    }

}
