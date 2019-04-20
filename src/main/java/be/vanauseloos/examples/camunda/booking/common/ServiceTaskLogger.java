package be.vanauseloos.examples.camunda.booking.common;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ServiceTaskLogger implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("ServiceTaskLogger: "+execution.getCurrentActivityName());
    }
}
