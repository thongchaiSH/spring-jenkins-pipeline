package com.jenkins.app.controller.exception;


import com.jenkins.app.model.base.BaseResponseWithData;
import com.jenkins.app.model.base.StatusType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity toResponse(Exception ex) {
        BaseResponseWithData result=BaseResponseWithData
                .missingFieldMessage(StatusType.internal_system_error,ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);

    }

}
