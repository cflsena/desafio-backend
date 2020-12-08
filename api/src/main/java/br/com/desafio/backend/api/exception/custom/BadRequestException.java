package br.com.desafio.backend.api.exception.custom;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -1812594310458109677L;

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
