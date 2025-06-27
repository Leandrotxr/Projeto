package br.inatel.exception;

public class CodigoInvalidoException extends Exception {

    public CodigoInvalidoException(String message) {
        super("Não existe " + message + " para este código");
    }
}
