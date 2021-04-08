package com.demo.baas.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ResetPinOperation implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

         System.out.println("Resetting pin..!");
    }
}
