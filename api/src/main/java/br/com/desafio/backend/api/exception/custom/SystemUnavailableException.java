package br.com.desafio.backend.api.exception.custom;

public class SystemUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 339474501303430070L;

    public SystemUnavailableException(Throwable cause) {
        super(cause);
    }

    public SystemUnavailableException(String msg) {
        super(msg);
    }

    public SystemUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

}
