package br.ada.customer.crud.examples.exception;

public class MainException {

    // Exception são exceção checadas, precisam ser tratadas ou estar no throws (assinatura do método)
    // RuntimeException, também são exception, porém, são exceptions não checadas (unchecked) e não precisam estar na assinatura ou no catch
    public static void main(String[] args) {
        Carro carro = new Carro(false);
        ligar(carro);
        carro.frear();
    }

    public static void ligar(Carro carro) throws RuntimeException {
        try {
            carro.ligar();
        } catch (CarroNaoLigaException exception) {
            try {
                carro.recebeNovaBateria();
            } catch (BateriaIncorretaException exception1) {
                throw new RuntimeException(exception1);
            }
            ligar(carro);
        }
    }

}
