package sber.winter.school.sberwinterschool.service;

import org.springframework.stereotype.Service;
import sber.winter.school.sberwinterschool.model.Terminal;
import sber.winter.school.sberwinterschool.repository.GenericRepository;

@Service
public class TerminalService extends GenericService<Terminal> {

  protected TerminalService(GenericRepository<Terminal> repository) {
    super(repository);
  }
}
