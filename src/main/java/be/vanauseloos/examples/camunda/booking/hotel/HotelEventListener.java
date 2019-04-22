package be.vanauseloos.examples.camunda.booking.hotel;

import be.vanauseloos.examples.camunda.ProcessConstants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HotelEventListener implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelEventListener.class);


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object delegateExecutionVariable = delegateExecution.getVariable(ProcessConstants.VAR_NAME_hotelId);

        LOGGER.debug("HotelEventListener. Id: " + delegateExecutionVariable);
    }
}
