package com.example.demo.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    @Scheduled(cron = "0 * 9 * * ?")
    public void cronJobScheduler(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String date = sdf.format(now);
//        System.out.println("Java Cron job: " + date);

    }
    @Scheduled(fixedRate = 1000)
    public void fixedRateSch(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String date = sdf.format(now);
//        System.out.println("Java Fixed Rate Scheduler: " +  date);
    }
    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void fixedDelaySch(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String date = sdf.format(now);
//        System.out.println("Fixed Delay Scheduler: " + date);
    }
}
