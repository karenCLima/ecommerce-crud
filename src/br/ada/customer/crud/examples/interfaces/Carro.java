package br.ada.customer.crud.examples.interfaces;

public abstract class Carro implements VeiculoAutomotor, Movimento {

    private Roda rodas;

    public Carro(Roda rodas) {
        this.rodas = rodas;
    }

    @Override
    public void deslocar() {
        System.out.println("Olha mãe, estou andando....");
        rodas.girarParaFrente();
    }

    public void setRodas(Roda rodas) {
        this.rodas = rodas;
    }

}
