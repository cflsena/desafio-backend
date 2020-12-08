package br.com.desafio.backend.api.exception;

import br.com.desafio.backend.api.exception.common.ExceptionMessageBuilder;
import br.com.desafio.backend.api.exception.constant.ApiResponseEntityExceptionConstant;
import br.com.desafio.backend.api.exception.custom.BadRequestException;
import br.com.desafio.backend.api.exception.custom.SystemUnavailableException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ExceptionMessageBuilder exceptionMessageBuilder;

    private ExceptionMessageBuilder getExceptionMessageBuilder() {
        return this.exceptionMessageBuilder;
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex,
                getExceptionMessageBuilder().buildErrorApi(HttpStatus.BAD_REQUEST,
                        getExceptionMessageBuilder().getUserMessage(ApiResponseEntityExceptionConstant.INVALID_MESSAGE), ex),
                headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, getExceptionMessageBuilder().buildErrorApi(HttpStatus.BAD_REQUEST, ex, ex.getBindingResult()),
                headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({SystemUnavailableException.class})
    public ResponseEntity<Object> handleSystemUnavailableException(SystemUnavailableException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                getExceptionMessageBuilder().buildErrorApi(HttpStatus.SERVICE_UNAVAILABLE,
                        getExceptionMessageBuilder().getUserMessage(ApiResponseEntityExceptionConstant.SYSTEM_UNAVAILABLE),
                        ExceptionUtils.getRootCauseMessage(ex)),
                new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, request);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                getExceptionMessageBuilder().buildErrorApi(HttpStatus.BAD_REQUEST,
                        ex.getMessage(),
                        ExceptionUtils.getRootCauseMessage(ex)),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
