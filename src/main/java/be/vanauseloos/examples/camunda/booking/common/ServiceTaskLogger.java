package be.vanauseloos.examples.camunda.booking.common;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceTaskLogger implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTaskLogger.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.debug("ServiceTaskLogger: " + execution.getCurrentActivityName());
    }
}
