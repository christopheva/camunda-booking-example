package be.vanauseloos.examples.camunda.booking.hotel;

import org.camunda.bpm.engine.RuntimeService;
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
    @Autowired
    private RuntimeService runtimeService;

    @JmsListener(destination = "order-queue")
    public void receiveMessage(@Payload Object payload,
                               @Headers MessageHeaders headers,
                               Message message, Session session) throws InterruptedException {

        System.out.println("=== MESSAGE RECEIVED ===");
        System.out.println(message);
        String businessKey = headers.get("BUSINESS-KEY", String.class);
        runtimeService.createMessageCorrelation("HotelBookEventMessage")
                .processInstanceBusinessKey(businessKey)
                .correlateWithResult();
    }

}
