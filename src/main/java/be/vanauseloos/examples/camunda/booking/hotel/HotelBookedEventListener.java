package be.vanauseloos.examples.camunda.booking.hotel;

import org.camunda.bpm.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

@Component
public class HotelBookedEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelBookedEventListener.class);


    @Autowired
    private RuntimeService runtimeService;

    @JmsListener(destination = "order-queue")
    public void receiveMessage(@Payload Object payload,
                               @Headers MessageHeaders headers,
                               Message message, Session session) throws InterruptedException {

        LOGGER.debug("=== MESSAGE RECEIVED ===");
        LOGGER.debug(message.toString());
        String businessKey = headers.get("BUSINESS-KEY", String.class);
        runtimeService.createMessageCorrelation("HotelBookEventMessage")
                .processInstanceBusinessKey(businessKey)
                .correlateWithResult();
    }

}
