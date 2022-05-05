package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts;

public enum IncomeBracket {
    LOWER(10), MIDDLE(12), UPPER(20);
    private final int percentile;

    IncomeBracket (int percentile) {
        this.percentile = percentile;
    }

    public int getPercentile() {
        return percentile;
    }
}
