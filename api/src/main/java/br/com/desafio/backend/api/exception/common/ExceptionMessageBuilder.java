package br.com.desafio.backend.api.exception.common;

import br.com.desafio.backend.api.exception.error.ApiError;
import br.com.desafio.backend.api.exception.error.ApiSubError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExceptionMessageBuilder {

    @Autowired
    private MessageSource messageSource;

    private MessageSource getMessageSource(){
        return this.messageSource;
    }

    public ApiError buildErrorApi(final HttpStatus status, String userMessage, String debugMessage) {
        return new ApiError(status, userMessage, debugMessage);
    }

    public ApiError buildErrorApi(final HttpStatus status, String userMessage, Exception ex) {
        return new ApiError(status, userMessage, ex);
    }

    public ApiError buildErrorApi(final HttpStatus status, Throwable ex,
                                  BindingResult bindingResult) {
        return new ApiError(status, ex, createListOfSubErrors(bindingResult));
    }

    public String getUserMessage(String keyMessage) {
        return getMessageSource().getMessage(keyMessage, null, LocaleContextHolder.getLocale());
    }

    private List<ApiSubError> createListOfSubErrors(BindingResult bindingResult) {
        List<ApiSubError> apiSubErrorList = new ArrayList<>();
        bindingResult.getFieldErrors()
                .forEach(item -> apiSubErrorList.add(new ApiSubError(item.getObjectName(), item.getField(),
                        item.getRejectedValue(), getMessageSource().getMessage(item, LocaleContextHolder.getLocale()))));

        return apiSubErrorList;
    }
}
