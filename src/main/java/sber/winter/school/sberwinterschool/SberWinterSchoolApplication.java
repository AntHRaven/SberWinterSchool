package sber.winter.school.sberwinterschool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SberWinterSchoolApplication {

  public static void main(String[] args) {
    SpringApplication.run(SberWinterSchoolApplication.class, args);
    log.info("Swagger-ui run on: http://localhost:9090/api/swagger-ui/index.html");
  }

}
