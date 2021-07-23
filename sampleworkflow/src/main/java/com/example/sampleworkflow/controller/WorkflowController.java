package com.example.sampleworkflow.controller;

import com.example.sampleworkflow.context.CurrentContext;
import com.example.sampleworkflow.models.RequestDTO;
import com.example.sampleworkflow.utils.WorkFlowUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workflow")
public class WorkflowController {
  @Autowired
  RuntimeService runtimeService;

  @Autowired
  WorkFlowUtil workFlowUtil;

  @PostMapping
  public String init(@RequestBody  RequestDTO requestDTO) {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("requestDTO", requestDTO);
    requestMap.put("root_url", "http://localhost:8080");
    runtimeService.startProcessInstanceByKey("weather-movie-app",
        requestDTO.getEmail(), requestMap);
    List<String> response = (List<String>) CurrentContext.get();
    return response.toString();
  }

  @DeleteMapping
  public boolean terminate(@RequestBody RequestDTO requestDTO) {
    runtimeService.createMessageCorrelation("end-flow")
        .processInstanceBusinessKey(requestDTO.getEmail()).correlate();
    //    workFlowUtil.terminateExistingProcess(requestDTO.getEmail());
    return true;
  }

}
