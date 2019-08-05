package com.globeking.springserver.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class ApplicationConfig {
  @Value("${spring.devtools.enable}")
  public String enableDevTools;
}
