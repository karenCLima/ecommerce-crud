package br.ada.customer.crud.examples.interfaces;

public class Celta extends CarroACombustao {

    public Celta(Roda rodas) {
        super(rodas);
    }

    @Override
    public void injectarCombustivel() {
        throw new RuntimeException("Nem uso combustível.....");
    }

}
