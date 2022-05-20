package com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service;

public class SalesManagerServiceException extends RuntimeException {
    public SalesManagerServiceException()
    {
        this(null);
    }

    public SalesManagerServiceException(String message)
    {
        this(message, null);
    }

    public SalesManagerServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        Throwable cause = this.getCause();

        return String.format("{message : %s%s}", super.getMessage(), cause != null ? ", causeMessage : " + cause.getMessage() : "");
    }
}
