package com.sengulkaya.app.service.rest.payrollmanagement.dto.exception.callbackinterfaces;

@FunctionalInterface
public interface ISupplierCallback<R> {
    R get() throws Exception;
}