package com.service.inter;

import com.model.UserInfo;

import java.util.List;

/**
 * Created by sniper on 2016/3/26.
 */
public interface IUserService {
    public boolean doLogin(UserInfo userInfo);

    public List<UserInfo> getUserList();
}
