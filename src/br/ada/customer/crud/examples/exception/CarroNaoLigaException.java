package br.ada.customer.crud.examples.exception;

public class CarroNaoLigaException extends Exception{

    public CarroNaoLigaException(String message, Exception cause) {
        super(message, cause);
    }
}
