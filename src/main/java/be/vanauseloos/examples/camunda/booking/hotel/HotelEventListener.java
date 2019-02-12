package be.vanauseloos.examples.camunda.booking.hotel;

import be.vanauseloos.examples.camunda.ProcessConstants;
import be.vanauseloos.examples.camunda.booking.common.BookingEvents;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HotelEventListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object delegateExecutionVariable = delegateExecution.getVariable(ProcessConstants.VAR_NAME_hotelId);

        System.out.println("HotelEventListener. Id: "+delegateExecutionVariable);
    }
}
