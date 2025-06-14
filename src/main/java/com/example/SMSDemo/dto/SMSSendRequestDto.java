package com.example.SMSDemo.dto;

import lombok.Data;

@Data
public class SMSSendRequestDto {
    private String destinationSMSPhoneNumber;
    private String smsMessage;
}
