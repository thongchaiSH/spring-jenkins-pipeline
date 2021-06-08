package com.jenkins.app.service;

import com.jenkins.app.model.CustomerRequest;
import com.jenkins.app.model.base.BaseResponse;

public interface FriendReferralService {
    public BaseResponse searchPolicy(CustomerRequest request) throws Exception;
}
