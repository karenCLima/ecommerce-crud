package br.ada.customer.crud.examples.interfaces;

public class MotorNuclear implements MotorHP, MotorLigavel {

    @Override
    public void gerarForca() {
        System.out.println("Gerando muita força.... aqui é body builder, birrllll");
    }

    @Override
    public void ligar() {
        System.out.println("Ligando o motor nuclear, corra!!!");
    }

}
