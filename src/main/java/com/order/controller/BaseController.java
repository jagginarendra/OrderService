package com.order.controller;

import com.microsoft.applicationinsights.TelemetryClient;
import com.order.exception.APINotRespondingException;
import com.order.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseController {


    @Autowired
    TelemetryClient telemetryClient;

    @ExceptionHandler(APINotRespondingException.class)
    public void handleAPINotRespondingException(APINotRespondingException e) {
        telemetryClient.trackException(e);
    }


}
