package com.sengulkaya.app.service.rest.payrollmanagement.data.entity.employee.contracts;

public enum IncomeBracket {
    LOWER(.1), MIDDLE(.12), UPPER(.2);
    private final double percentile;

    IncomeBracket (double percentile) {
        this.percentile = percentile;
    }

    public double getPercentile() {
        return percentile;
    }
}
