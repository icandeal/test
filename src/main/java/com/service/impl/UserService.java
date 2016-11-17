package com.service.impl;

import com.dao.facade.IMapperFacade;
import com.model.UserInfo;
import com.model.UserInfoExample;
import com.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sniper on 2016/3/26.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    IMapperFacade mapperFacade;

    public boolean doLogin(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria()
            .andUsernameEqualTo(userInfo.getUsername())
            .andPasswordEqualTo(userInfo.getPassword());

        List<UserInfo> userInfoList = mapperFacade.getUserInfoMapper().selectByExample(userInfoExample);

        if(userInfoList == null || userInfoList.size() < 1)
            return false;
        return true;
    }

    public List<UserInfo> getUserList(){
        List<UserInfo> userList = null;

        userList = mapperFacade.getUserInfoMapper().selectByExample(null);

        return userList;
    }
}
