package br.ada.customer.crud.examples.interfaces;

public abstract class CarroACombustao extends Carro {

    public CarroACombustao(Roda rodas) {
        super(rodas);
    }

    public void injectarCombustivel() {
        //Motor e injetar o combustivel
        System.out.println("Injectando combustivel no motor");
    }

}
