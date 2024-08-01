package org.bbosiregi.demo.util.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    NOT_FOUND_RESOURCE(HttpStatus.NOT_FOUND, "C001", "Not Found Entity"),
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "C002", "Data Already in the DataBase"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C003", "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C004", "Internal Server Error"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "C005", "Wrong Access. Try Another Request"),
    INVALID_TYPE_VALUE(HttpStatus.NOT_FOUND, "C006", "Invalid Type Value"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "C007", "Unauthorized"),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST,"T001","Invalid Token Input"),
    NO_ACCESS_AUTHORIZED(HttpStatus.FORBIDDEN, "T002", "No Access Allowed"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "T003", "Token Expired"),
    NO_SIGN_IN(HttpStatus.UNAUTHORIZED, "T003", "No Sign In"),
    ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "T004", "Refresh Token Expired"),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "T005", "Refresh Token Expired"),
    U_DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "U001", "Data Already in the DataBase"),
    U_NOT_FOUND_RESOURCE(HttpStatus.NOT_FOUND, "U002", "Not Found Entity"),
    U_NEED_REDIRECT_TOKEN(HttpStatus.NOT_FOUND, "U003", "Request Unauthorized Token User"),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
