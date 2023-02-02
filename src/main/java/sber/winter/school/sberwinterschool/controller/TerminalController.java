package sber.winter.school.sberwinterschool.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sber.winter.school.sberwinterschool.dto.TerminalDto;
import sber.winter.school.sberwinterschool.mapper.GenericMapper;
import sber.winter.school.sberwinterschool.model.Terminal;
import sber.winter.school.sberwinterschool.service.GenericService;

@RestController
@RequestMapping("/terminal")
@Tag(name = "Терминалы",
     description = "Контроллер для работы с терминалами")
public class TerminalController extends GenericController<Terminal, TerminalDto>{

  protected TerminalController(GenericService<Terminal> service,
      GenericMapper<Terminal, TerminalDto> mapper) {
    super(service, mapper);
  }
}
