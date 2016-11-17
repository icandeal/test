package com.dao.facade;

import com.dao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sniper on 2016/3/26.
 */
@Component
public class MapperFacade implements IMapperFacade {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfoMapper getUserInfoMapper() {
        return userInfoMapper;
    }
}
