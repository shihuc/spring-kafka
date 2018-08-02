package com.roomdis.micros.kafka.consumer;

import com.roomdis.micros.kafka.common.Config;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by chengsh05 on 2018-07-31.
 */
@Service
public class MessageConsumer {

    private Logger logger = Logger.getLogger(MessageConsumer.class);

//    @KafkaListener(topics = Config.TOPIC)
//    public void onMessage(@Payload String msg, Acknowledgment ack){
//        logger.info(msg);
////        long offset = record.offset();
////        long partition = record.partition();
////        String content = record.value();
////        logger.info("offset: " + offset + ", partition: " + partition + ", content: " + content);
//        ack.acknowledge();
//    }

    @KafkaListener(topics = Config.TOPIC)
    public void onMessage(ConsumerRecord<String, String> record, Acknowledgment ack){
        logger.info(record);
        long offset = record.offset();
        long partition = record.partition();
        String content = record.value();
        logger.info("offset: " + offset + ", partition: " + partition + ", payload: " + content);
        //手动确认消息已经被消费，这个很重要，灵活控制，保证消息消费确认的问题。
        ack.acknowledge();
    }
}
