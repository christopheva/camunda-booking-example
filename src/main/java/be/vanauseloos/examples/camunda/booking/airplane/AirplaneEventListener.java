package be.vanauseloos.examples.camunda.booking.airplane;

import be.vanauseloos.examples.camunda.ProcessConstants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AirplaneEventListener implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirplaneEventListener.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object delegateExecutionVariable = delegateExecution.getVariable(ProcessConstants.VAR_NAME_airplaneId);

        /**
         * BOOK AIRPLANE
         */

        LOGGER.debug("AirplaneEventListener. Id: " + delegateExecutionVariable);
    }
}
