package org.camunda.bpm.getstarted.loanapproval;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/not-robot")
public class DemoController {

  @Autowired
  RuntimeService runtimeService;

  @GetMapping("/{id}")
  public ResponseEntity initiate(@PathVariable(name = "id") String id) {
    DemoContext context = new DemoContext();
    CurrentContext.set(context);
    Map<String, Object> variables = new HashMap<>();

    if (isNonDuplicateRequest(id)) {
      variables.put("attemptsRemaining", 0);
      runtimeService.startProcessInstanceByKey("not-robot", id, variables);
      runtimeService.createMessageCorrelation("initiate")
          .processInstanceBusinessKey(id).correlate();
    } else {
      runtimeService.createMessageCorrelation("regenerate")
          .processInstanceBusinessKey(id).correlate();
    }
    String response = context.getMessage();

    return new ResponseEntity(response, HttpStatus.OK);
  }

  @PostMapping("/validate/{id}")
  public ResponseEntity regenerate(@PathVariable(name = "id") String id, @RequestBody Map input) {

    Map variables = runtimeService.getVariables(runtimeService.createProcessInstanceQuery()
        .processInstanceBusinessKey(id).singleResult().getProcessInstanceId());
    boolean valid = false;
    int attempts= (int) variables.get("attemptsRemaining");
    int attemptsremaining = 3- attempts;
    String response = "Unsuccessful, attempts remaining: " +attemptsremaining;
    if (input.get("value") == variables.get("sum")) {
      valid = true;
      response = "success";
    }
    else
    {
      DemoContext context = new DemoContext();
      CurrentContext.set(context);
    }
    Map reqMap = new HashMap<String, Object>();
    reqMap.put("valid", valid);
    runtimeService.createMessageCorrelation("validate")
        .processInstanceBusinessKey(id).setVariables(reqMap).correlate();

    return new ResponseEntity(response, HttpStatus.OK);
  }

  private boolean isNonDuplicateRequest(String onboardingId) {
    return Objects
        .isNull(runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(onboardingId).singleResult());
  }
}
