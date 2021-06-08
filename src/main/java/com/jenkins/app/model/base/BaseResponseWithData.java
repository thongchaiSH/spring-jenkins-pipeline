package com.jenkins.app.model.base;

import lombok.Data;

@Data
public class BaseResponseWithData<T> extends BaseResponse {
    private T data;

    public BaseResponseWithData(){

    }

    public static <T> BaseResponseWithData<T> successMessage(T data){
        BaseResponseWithData<T> response=new BaseResponseWithData<T>();
        response.setData(data);
        response.setStatus(StatusType.success.getStatus());
        response.setStatusCode(StatusType.success.getStatusCode());
        response.setMessage(StatusType.success.getMessage());
        return response;
    }

    public static <T> BaseResponseWithData<T> failedMessage(StatusType statusType){
        BaseResponseWithData<T> response=new BaseResponseWithData<T>();
        response.setStatus(statusType.getStatus());
        response.setStatusCode(statusType.getStatusCode());
        response.setMessage(statusType.getMessage());
        return response;
    }

    public static <T> BaseResponseWithData<T> missingFieldMessage(StatusType statType, String missingFieldName) {
        BaseResponseWithData<T> response = new BaseResponseWithData<T>();
        response.setStatus(statType.getStatus());
        response.setStatusCode(statType.getStatusCode());
        response.setMessage(statType.getMessage().concat(missingFieldName));
        return response;
    }
}
