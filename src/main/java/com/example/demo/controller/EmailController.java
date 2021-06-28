package com.example.demo.controller;

import com.example.demo.dao.MailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    public MailDao mailDao;

    @RequestMapping(value = "/sendmail")
    public String sendEmail(){
        return mailDao.sendMail();
    }

    @RequestMapping(value = "/sendsms")
    public String sendSms(){
        return mailDao.sendSms();
    }
    @RequestMapping(value = "/makecall")
    public String makeCall(){
        return mailDao.makeCall();
    }
}
