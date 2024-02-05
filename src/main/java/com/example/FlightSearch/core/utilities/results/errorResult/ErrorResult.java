package com.example.FlightSearch.core.utilities.results.errorResult;

import com.example.FlightSearch.core.utilities.results.Result;

public class ErrorResult extends Result {
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}
