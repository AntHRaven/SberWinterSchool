package sber.winter.school.sberwinterschool.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.TerminalDto;
import sber.winter.school.sberwinterschool.model.Terminal;

@Component
public class TerminalMapper extends GenericMapper<Terminal, TerminalDto> {

  protected TerminalMapper(ModelMapper mapper) {
    super(mapper, Terminal.class, TerminalDto.class);
  }
}
