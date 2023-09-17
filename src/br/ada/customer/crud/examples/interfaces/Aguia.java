package br.ada.customer.crud.examples.interfaces;

public class Aguia implements Voavel{

    @Override
    public void decolar() {
        System.out.println("Decolando.... Equipe roquete");
    }

    @Override
    public void voar() {
        System.out.println("Voando");
    }

    @Override
    public void pousar() {
        System.out.println("Pousou no galho");
    }

}
