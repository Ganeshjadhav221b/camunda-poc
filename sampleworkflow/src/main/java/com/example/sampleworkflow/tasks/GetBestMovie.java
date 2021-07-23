package com.example.sampleworkflow.tasks;

import com.example.sampleworkflow.context.CurrentContext;
import com.example.sampleworkflow.models.RequestDTO;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public class GetBestMovie implements BaseTask {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Map<String, Object> executionVariables = execution.getVariables();
    String movies = (String) executionVariables.get("movie-list");
    List<String> movieList = Arrays.asList(movies.split(","));
    String weather = (String) executionVariables.get("weather");
    RequestDTO requestDTO = (RequestDTO) executionVariables.get("requestDTO");
    Random random = new Random();
    int i = random.nextInt(movieList.size()-1);
    int part = random.nextInt(3) + 1;
    CurrentContext.set(Arrays.asList("Yay!",
        "With temperature of " + weather + " degrees in " + requestDTO.getCity() + ", we recommend you " + movieList.get(i)
            + "-" + part));
  }
}
