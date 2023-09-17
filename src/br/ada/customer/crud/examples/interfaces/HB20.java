package br.ada.customer.crud.examples.interfaces;

public class HB20 extends CarroACombustao{

    public HB20(Roda rodas) {
        super(rodas);
    }

    @Override
    public void injectarCombustivel() {
        //Aquecimento do etanol se a temperatura estiver abaixo de 20
        super.injectarCombustivel();
    }
}
