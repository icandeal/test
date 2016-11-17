package com.service.facade;

import com.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sniper on 2016/3/26.
 */
@Service
public class ServiceFacade implements IServiceFacade {
    @Autowired
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }
}
