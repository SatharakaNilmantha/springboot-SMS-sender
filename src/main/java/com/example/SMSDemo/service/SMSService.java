package com.example.SMSDemo.service;

import com.example.SMSDemo.dto.SMSSendRequestDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@Slf4j
public class SMSService {

    @Value("${TWILIO_ACCOUNT_SID}")
    private String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    private String OUTGOING_SMS_NUMBER;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        log.info("Twilio initialized with SID: {}", ACCOUNT_SID);
        log.info("Twilio initialized with AUTH_TOKEN : {}", AUTH_TOKEN);
    }

    public String sendSMS(SMSSendRequestDto requestDto) {


        Message message = Message.creator(
                new PhoneNumber(requestDto.getDestinationSMSPhoneNumber()),
                new PhoneNumber(OUTGOING_SMS_NUMBER),
                requestDto.getSmsMessage()
        ).create();

        String status = message.getStatus().toString();
        log.info("SMS sent with status: {}", status);


        return status;
    }
}
