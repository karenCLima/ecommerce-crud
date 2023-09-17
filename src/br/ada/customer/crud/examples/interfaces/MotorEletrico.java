package br.ada.customer.crud.examples.interfaces;

public class MotorEletrico implements MotorHP {

    @Override
    public void gerarForca() {
        System.out.println("Gerando força de propulsão.....");
    }

}
