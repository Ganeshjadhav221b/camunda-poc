package com.example.sampleworkflow.tasks;

import java.util.Objects;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.ResponseEntity;

/**
 * The Class BaseTask.
 */
public interface BaseTask extends JavaDelegate {

  public default Object getBody(ResponseEntity<Object> response) {
    if (Objects.nonNull(response)) {
      return response.getBody();
    }
    return null;
  }

}
