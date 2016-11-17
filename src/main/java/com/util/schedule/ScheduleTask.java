package com.util.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by sniper on 2016/3/12.
 */
@Component
public class ScheduleTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void checkTask(){
        System.out.println("Im OK !!!");
    }
}
