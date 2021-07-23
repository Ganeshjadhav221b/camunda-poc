package com.example.sampleworkflow.models;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
  @NotBlank(message="is required")
  private String email;
  private int age;
  @NotBlank(message="is required")
  private String city;
  @NotBlank(message="is required")
  private String preferenceInterval;
}
