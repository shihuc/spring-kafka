package com.roomdis.micros.kafka;

import com.roomdis.micros.kafka.dto.LogMessage;
import com.roomdis.micros.kafka.producer.MessageProducer;
import com.roomdis.micros.kafka.utils.ServerAddrHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.management.MalformedObjectNameException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by chengsh05 on 2018-07-31.
 */
@SpringBootApplication
public class KafkaApplication {

    public static void main(String []args) throws MalformedObjectNameException, UnknownHostException {
        ApplicationContext app = SpringApplication.run(KafkaApplication.class, args);
        MessageProducer producer = app.getBean(MessageProducer.class);
        while(true) {
            LogMessage logMessage = new LogMessage();
            logMessage.setContent(UUID.randomUUID().toString() + ":" + new Date().toString());
            logMessage.setFullClassPath(KafkaApplication.class.toString());
            logMessage.setServerAddr(ServerAddrHelper.getIpAddressAndPort());
            logMessage.setMessageTime(new Date().toString());
            producer.send(logMessage);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
