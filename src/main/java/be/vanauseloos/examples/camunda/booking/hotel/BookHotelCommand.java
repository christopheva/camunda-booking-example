package be.vanauseloos.examples.camunda.booking.hotel;

import be.vanauseloos.examples.camunda.ProcessConstants;
import org.apache.activemq.ScheduledMessage;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class BookHotelCommand implements JavaDelegate {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception {
        Object delegateExecutionVariable = delegateExecution.getVariable(ProcessConstants.VAR_NAME_hotelId);

        jmsTemplate.convertAndSend("order-queue", delegateExecutionVariable, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 10000); //Fake external process time
                message.setStringProperty("BUSINESS-KEY", delegateExecution.getProcessBusinessKey());
                return message;
            }
        });


        System.out.println("=== MESSAGE SEND ===");
        System.out.println("BookHotelCommand. Id: " + delegateExecutionVariable);

    }
}
