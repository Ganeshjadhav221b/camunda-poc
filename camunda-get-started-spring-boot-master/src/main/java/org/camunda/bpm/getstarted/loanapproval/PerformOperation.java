package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PerformOperation implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Long inp1 = (Long) delegateExecution.getVariable("inp1");
        Long inp2 = (Long) delegateExecution.getVariable("inp2");
        String inp3 = (String) delegateExecution.getVariable("inp3");
        Long res = Long.valueOf(0);
        switch(inp3)
        {
            case "+":
                res = inp1 + inp2;
                break;
            case "-":
                res = inp1 - inp2;
                break;
            case "*":
                res = inp1 * inp2;
                break;
            case "/":
                res = inp1 / inp2;
                break;
        }

        System.out.println("Result is "+res);
    }
}
