package org.bbosiregi.demo.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class HttpResponse<T> {
    @JsonProperty("status")
    private HttpStatusCode status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;

    public HttpResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
