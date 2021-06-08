package com.jenkins.app.model.base;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class BaseResponse {
    private int statusCode;
    private String status;
    private String message;
    private List<Map<String, String>> errorMessage;

    //    public boolean isSuccess(){
//
//    }
    public List<String> getErrorMessage() {
        List<String> errMsgList = new ArrayList<>();
        if(errorMessage != null)
        {
            this.errorMessage.forEach((data) -> {
                List<String> msg = data.entrySet().stream()
                        .map(e -> e.getKey() + ":" + e.getValue())
                        .collect(Collectors.toList());

                errMsgList.addAll(msg);
            });
        }
        return errMsgList;
    }
}
