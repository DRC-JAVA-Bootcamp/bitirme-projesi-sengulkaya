package com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service;

public class WorkerServiceException extends RuntimeException {
    public WorkerServiceException()
    {
        this(null);
    }

    public WorkerServiceException(String message)
    {
        this(message, null);
    }

    public WorkerServiceException(String message, Throwable cause)
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
