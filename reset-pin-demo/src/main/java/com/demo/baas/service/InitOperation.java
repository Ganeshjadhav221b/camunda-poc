package com.demo.baas.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InitOperation implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

         System.out.println("Initiating reset-pin services..!");
    }
}
