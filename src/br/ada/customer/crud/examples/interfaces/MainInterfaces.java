package br.ada.customer.crud.examples.interfaces;

public class MainInterfaces {

    public static void main(String[] args) {
        HB20 hb20 = new HB20(new RodaDeFerro());
        hb20.deslocar();
        hb20.setRodas(new RodaDeAluminio());
        hb20.deslocar();
    }



}
