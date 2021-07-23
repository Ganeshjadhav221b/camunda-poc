import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class CalculateRequestApplication {

  public static void main(String[] args) {
    SpringApplication.run(CalculateRequestApplication.class, args);
  }
  ProcessEngine engine = BpmPlatform.getDefaultProcessEngine();
}
