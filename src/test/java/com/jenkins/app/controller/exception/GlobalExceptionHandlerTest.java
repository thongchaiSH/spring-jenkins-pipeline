package com.jenkins.app.controller.exception;

import com.jenkins.app.model.base.BaseResponseWithData;
import com.jenkins.app.model.base.StatusType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler=new GlobalExceptionHandler();

    @Test
    void Should_ThrowStatus500_When_Exception() {
        //given
        String errorMessage= UUID.randomUUID().toString();
        Exception exception=new Exception(errorMessage);
        //when
        ResponseEntity response=handler.toResponse(exception);
        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

        Object  bodyObj= response.getBody();
        BaseResponseWithData baseResponse=(BaseResponseWithData)bodyObj;
        assertThat(baseResponse.getStatusCode()).isEqualTo(StatusType.internal_system_error.getStatusCode());
        assertThat(baseResponse.getMessage()).contains(errorMessage);
        assertThat(baseResponse.getData()).isNull();
    }

}