package com.example.sampleworkflow.tasks;

import com.example.sampleworkflow.context.CurrentContext;
import java.util.Arrays;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public class NotAdultResponse implements BaseTask {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    //Do some other stuff here.
    CurrentContext.set(Arrays.asList("failed","User is not adult"));
  }
}
