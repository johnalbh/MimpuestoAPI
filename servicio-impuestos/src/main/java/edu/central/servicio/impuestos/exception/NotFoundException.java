package edu.central.servicio.impuestos.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1l;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
