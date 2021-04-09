package org.camunda.bpm.getstarted.loanapproval;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InitiateTask implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) throws Exception {
    updateAttempts(execution);
    Map resMap = new HashMap<String, Object>();
    generateNumbers(resMap);
    execution.setVariables(resMap);
  }
  private void generateNumbers(Map resMap) {
    Random rand = new Random();

    int num1 = rand.nextInt(100);
    int num2 = rand.nextInt(100);
    int sum = num1 + num2;
    resMap.put("num1", num1);
    resMap.put("num2", num2);
    resMap.put("sum", sum);
    DemoContext context = (DemoContext) CurrentContext.get();
    context.setMessage("The 2 numbers are " + num1 + " and " + num2);
  }
  private void updateAttempts(DelegateExecution execution) {
    Map reqMap = execution.getVariables();
    int attempts = (int) reqMap.get("attemptsRemaining");
    reqMap.put("attempts", attempts + 1);
    execution.setVariables(reqMap);
  }
}
