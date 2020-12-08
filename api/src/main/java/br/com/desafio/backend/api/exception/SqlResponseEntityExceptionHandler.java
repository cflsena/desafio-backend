package br.com.desafio.backend.api.exception;

import br.com.desafio.backend.api.exception.common.ExceptionMessageBuilder;
import br.com.desafio.backend.api.exception.constant.ApiResponseEntityExceptionConstant;
import br.com.desafio.backend.api.exception.custom.UniqueConstraintException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SqlResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ExceptionMessageBuilder exceptionMessageBuilder;

    private ExceptionMessageBuilder getExceptionMessageBuilder() {
        return this.exceptionMessageBuilder;
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
                                                                       WebRequest request) {
        return handleExceptionInternal(ex,
                getExceptionMessageBuilder().buildErrorApi(HttpStatus.NOT_FOUND,
                        getExceptionMessageBuilder().getUserMessage(ApiResponseEntityExceptionConstant.RESOURCE_NOT_FOUND), ex),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                        WebRequest request) {
        return handleExceptionInternal(ex,
                getExceptionMessageBuilder().buildErrorApi(HttpStatus.BAD_REQUEST,
                        getExceptionMessageBuilder().getUserMessage(ApiResponseEntityExceptionConstant.OPERATION_NOT_PERMITTED),
                        ExceptionUtils.getRootCauseMessage(ex)),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({UniqueConstraintException.class})
    public ResponseEntity<Object> handleUniqueConstraintException(UniqueConstraintException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                getExceptionMessageBuilder().buildErrorApi(HttpStatus.BAD_REQUEST,
                        ex.getMessage(),
                        ExceptionUtils.getRootCauseMessage(ex)),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
