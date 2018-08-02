package com.roomdis.micros.kafka.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.roomdis.micros.kafka.common.Config;
import com.roomdis.micros.kafka.dto.LogMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by chengsh05 on 2018-07-31.
 */
@Service
public class MessageProducer {
    private Logger logger = Logger.getLogger(MessageProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(LogMessage logMessage) {
        String msg = gson.toJson(logMessage);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(Config.TOPIC, msg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                long offset = stringStringSendResult.getRecordMetadata().offset();
                String cont = stringStringSendResult.getProducerRecord().toString();
                logger.info("cont: " + cont + ", offset: " + offset);
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error(throwable.getMessage());
            }
        });
    }
}
