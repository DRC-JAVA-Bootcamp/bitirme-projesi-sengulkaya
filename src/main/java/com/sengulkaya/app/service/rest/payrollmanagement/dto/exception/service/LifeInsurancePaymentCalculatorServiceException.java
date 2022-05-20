package com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.service;

public class LifeInsurancePaymentCalculatorServiceException extends RuntimeException {

    public LifeInsurancePaymentCalculatorServiceException()
    {
        this(null);
    }

    public LifeInsurancePaymentCalculatorServiceException(String message)
    {
        this(message, null);
    }

    public LifeInsurancePaymentCalculatorServiceException(String message, Throwable cause)
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
