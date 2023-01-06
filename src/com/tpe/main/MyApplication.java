package com.tpe.main;

import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import com.tpe.service.WhatsuppService;

public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Siparisler kargoya verildi.");

        //1. Asama
        /*

        MessageService mailService = new MailService();
        mailService.sendMessage(message);

        SmsService smsService = new SmsService();
        smsService.sendMessage(message);

        WhatsuppService whatsuppService = new WhatsuppService();
        whatsuppService.sendMessage(message);

         */

        String serviceName = "mailService";
        MessageService service;

        if(args.length>0){
            serviceName = args[0];
        }
            if (serviceName.equalsIgnoreCase("whatsAppservice")){
                service = new WhatsuppService();
            }else if (serviceName.equalsIgnoreCase("smsService")){
                service = new SmsService();
            }else {
                service = new MailService();
            }
            service.sendMessage(message);

    }
}
