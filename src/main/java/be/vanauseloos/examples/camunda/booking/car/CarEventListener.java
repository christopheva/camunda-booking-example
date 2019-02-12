package be.vanauseloos.examples.camunda.booking.car;

import be.vanauseloos.examples.camunda.ProcessConstants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CarEventListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object delegateExecutionVariable = delegateExecution.getVariable(ProcessConstants.VAR_NAME_carId);

        System.out.println("CarEventListener. Id: "+delegateExecutionVariable);
    }
}
