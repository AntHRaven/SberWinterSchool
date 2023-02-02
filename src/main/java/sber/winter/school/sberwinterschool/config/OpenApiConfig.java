package sber.winter.school.sberwinterschool.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI libraryProject() {
    return new OpenAPI()
        .info(new Info()
            .description("API для получения информации о терминалах")
            .title("Terminals")
            .version("v0.1")
            .contact(new Contact().name("Incognito"))
        );
  }
}
