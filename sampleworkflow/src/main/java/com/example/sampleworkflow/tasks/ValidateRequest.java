package com.example.sampleworkflow.tasks;

import com.example.sampleworkflow.models.RequestDTO;
import java.util.Map;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public class ValidateRequest implements BaseTask {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    RequestDTO requestDTO= (RequestDTO) execution.getVariables().get("requestDTO");
    int age = requestDTO.getAge();
    boolean isAdult = age > 18;
    Map<String, Object> reqMap = execution.getVariables();
    reqMap.put("isAdult",isAdult);
    execution.setVariables(reqMap);
  }
}
