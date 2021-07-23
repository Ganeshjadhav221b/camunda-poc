package com.example.sampleworkflow.tasks;

import com.example.sampleworkflow.context.CurrentContext;
import java.util.Arrays;
import java.util.List;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public class WriteBestMovie implements BaseTask {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    //Do some other stuff here.
    List<String> result = (List<String>) CurrentContext.get();
    System.out.println(result.toString());
  }
}
