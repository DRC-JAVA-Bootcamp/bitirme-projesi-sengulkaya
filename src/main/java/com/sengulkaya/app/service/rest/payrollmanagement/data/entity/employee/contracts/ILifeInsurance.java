package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts;

public interface ILifeInsurance {
    default IncomeBracket setBraket(double val)
    {
        IncomeBracket incomeBracket = null;
        if (val <= 10000)
            throw new IllegalArgumentException("No value under 10000 is legal!");
        if (val < 25000)
            incomeBracket = IncomeBracket.LOWER;
        else if (val < 50000)
            incomeBracket = IncomeBracket.MIDDLE;
        else
            incomeBracket = IncomeBracket.UPPER;
        return incomeBracket;
    }
    double calculateInsurancePayment();//bonus + extra + base salary...
}
