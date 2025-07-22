package org.example.panacea.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class MessageSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Received message: %s ".formatted(message.toString()));
    }
}