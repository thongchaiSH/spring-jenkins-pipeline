package com.jenkins.app.service;


import com.jenkins.app.model.CustomerRequest;
import com.jenkins.app.model.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FriendReferralServiceImpl implements FriendReferralService{
    @Override
    public BaseResponse searchPolicy(CustomerRequest request) throws Exception {
        BaseResponse response=new BaseResponse();
        return response;
    }
}
