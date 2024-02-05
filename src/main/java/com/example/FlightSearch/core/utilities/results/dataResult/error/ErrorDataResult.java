package com.example.FlightSearch.core.utilities.results.dataResult.error;

import com.example.FlightSearch.core.utilities.results.dataResult.DataResult;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(String message, T data) {
        super(false, message, data);
    }

    public ErrorDataResult(T data) {
        super(false, data);
    }

    public ErrorDataResult(String message) {
        super(false, message, null);
    }

    public ErrorDataResult() {
        super(false, null);
    }
}
