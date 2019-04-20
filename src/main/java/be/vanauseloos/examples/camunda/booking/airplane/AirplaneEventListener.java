package be.vanauseloos.examples.camunda.booking.airplane;

import be.vanauseloos.examples.camunda.ProcessConstants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AirplaneEventListener implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object delegateExecutionVariable = delegateExecution.getVariable(ProcessConstants.VAR_NAME_airplaneId);

        System.out.println("AirplaneEventListener. Id: " + delegateExecutionVariable);
    }
}
