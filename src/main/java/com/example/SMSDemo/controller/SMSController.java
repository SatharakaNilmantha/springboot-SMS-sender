package com.example.SMSDemo.controller;

import com.example.SMSDemo.dto.SMSSendRequestDto;
import com.example.SMSDemo.service.SMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sms")
@Slf4j
public class SMSController {

    @Autowired
    private  SMSService smsService;


    @PostMapping("/send")
    public String sendSMS(@RequestBody SMSSendRequestDto requestDto) {
        return smsService.sendSMS(requestDto);
    }
}
