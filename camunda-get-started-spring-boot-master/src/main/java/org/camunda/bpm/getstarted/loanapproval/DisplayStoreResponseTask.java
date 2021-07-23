package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DisplayStoreResponseTask implements JavaDelegate {
  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {
    System.out.println("Stored in db: " + delegateExecution.getVariable("storeOutput"));
  }
}
