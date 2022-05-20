package com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service;

public class ManagerServiceException extends RuntimeException {
    public ManagerServiceException()
    {
        this(null);
    }

    public ManagerServiceException(String message)
    {
        this(message, null);
    }

    public ManagerServiceException(String message, Throwable cause)
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
