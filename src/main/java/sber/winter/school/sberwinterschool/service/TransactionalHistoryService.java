package sber.winter.school.sberwinterschool.service;

import org.springframework.stereotype.Service;
import sber.winter.school.sberwinterschool.model.TransactionalHistory;
import sber.winter.school.sberwinterschool.repository.GenericRepository;

@Service
public class TransactionalHistoryService extends GenericService<TransactionalHistory> {

  protected TransactionalHistoryService(GenericRepository<TransactionalHistory> repository) {
    super(repository);
  }
}
