package org.bbosiregi.demo.util.error.handler;

import lombok.Getter;
import org.bbosiregi.demo.util.error.ErrorCode;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message == null || message.trim().isEmpty() ? errorCode.getMessage() : message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
