
package com.codingshuttle.prod_ready_fearures.advice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiResponse<T> {

    private LocalDateTime timeStamp;
    private T data;
    private ApiError apiError;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.apiError = error;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    // Custom deserialization
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = LocalDateTime.parse(timeStamp, FORMATTER);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }
}