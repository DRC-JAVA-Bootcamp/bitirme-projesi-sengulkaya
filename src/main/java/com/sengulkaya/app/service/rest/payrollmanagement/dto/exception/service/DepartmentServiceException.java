package com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service;

public class DepartmentServiceException extends RuntimeException {
    public DepartmentServiceException()
    {
        this(null);
    }

    public DepartmentServiceException(String message)
    {
        this(message, null);
    }

    public DepartmentServiceException(String message, Throwable cause)
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
