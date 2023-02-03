package sber.winter.school.sberwinterschool.repository;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;
import sber.winter.school.sberwinterschool.model.Shop;
import sber.winter.school.sberwinterschool.model.Terminal;

@Repository
public interface TerminalRepository extends GenericRepository<Terminal> {
  List<Terminal> findAllByIdIn(List<Long> ids);

}
