package be.vanauseloos.examples.camunda.booking.car;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookCarCommand implements JavaDelegate {
    @Autowired
    RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        runtimeService.createMessageCorrelation("BookCarCommandMessage")
                .processInstanceBusinessKey(execution.getProcessBusinessKey())
                .setVariable("carId", execution.getVariable("carId"))
                .correlate();
    }
}
