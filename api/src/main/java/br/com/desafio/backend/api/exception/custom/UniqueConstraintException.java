package br.com.desafio.backend.api.exception.custom;

public class UniqueConstraintException extends RuntimeException {

    private static final long serialVersionUID = -3976385956044804338L;

    public UniqueConstraintException(Throwable cause) {
        super(cause);
    }

    public UniqueConstraintException(String msg) {
        super(msg);
    }

    public UniqueConstraintException(String message, Throwable cause) {
        super(message, cause);
    }

}
