package com.example.springbootschedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by suneee on 2018/6/15.
 */
@Component
public class ScheduleTask {

    private final static Logger log = LoggerFactory.getLogger(ScheduleTask.class);

    private final static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void currentTime() {
        log.info("Current Time:" + sdf.format(new Date()));
    }
}
