package com.example.sampleworkflow.utils;

import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkFlowUtil {
  @Autowired
  RuntimeService runtimeService;

  public boolean terminateExistingProcess(String businessKey) {
    ProcessInstance processInstance = this.getExistingProcess(businessKey);
    if (null != processInstance) {
      runtimeService.deleteProcessInstance(processInstance.getProcessInstanceId(), "Duplicate process");
      return true;
    }
    return false;
  }

  public String getExistingProcessId(String businessKey) {
    ProcessInstance processInstance = null;
    if (StringUtils.isBlank(businessKey)) { return null; }
    try {
      processInstance = this.getExistingProcess(businessKey);
    } catch (Exception e) {
      // invalid ProcessID
      return null;
    }
    if (null != processInstance) {
      return processInstance.getProcessInstanceId();
    }
    return null;
  }

  public ProcessInstance getExistingProcess(String businessKey) {
    ProcessInstance processInstance = null;
    try {
      processInstance = runtimeService.createProcessInstanceQuery()
          .processInstanceBusinessKey(businessKey).singleResult();
    } catch (Exception e) {
    }
    return processInstance;
  }
}
