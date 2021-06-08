package com.jenkins.app.controller;

import com.jenkins.app.model.CustomerRequest;
import com.jenkins.app.model.base.BaseResponse;
import com.jenkins.app.service.FriendReferralService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/friendReferral", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api("FriendReferral")
public class FriendReferralController {

    @Autowired
    FriendReferralService friendReferralService;

    @PostMapping("/searchPolicy")
    public BaseResponse searchPolicy(@RequestBody CustomerRequest customerRequest){
        BaseResponse retValue=null;
        try{
            retValue=  friendReferralService.searchPolicy(customerRequest);
        }catch (Exception e){
            log.error("Error : {}",e.getMessage());
        }
        return retValue;
    }

}
