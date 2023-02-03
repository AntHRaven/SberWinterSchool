package sber.winter.school.sberwinterschool.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import sber.winter.school.sberwinterschool.model.Terminal;
import sber.winter.school.sberwinterschool.model.TransactionalHistory;

@Repository
public interface TransactionalHistoryRepository extends GenericRepository<TransactionalHistory> {
  List<TransactionalHistory> findAllByIdIn(List<Long> ids);

}
