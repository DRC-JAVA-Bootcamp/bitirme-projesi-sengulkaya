package com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service;

public class ProjectWorkerServiceException extends RuntimeException{
    public ProjectWorkerServiceException()
    {
        this(null);
    }

    public ProjectWorkerServiceException(String message)
    {
        this(message, null);
    }

    public ProjectWorkerServiceException(String message, Throwable cause)
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
