package sber.winter.school.sberwinterschool.repository;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;
import sber.winter.school.sberwinterschool.model.Shop;

@Repository
public interface ShopRepository extends GenericRepository<Shop> {

  Set<Shop> findAllByIdIn(List<Long> ids);

}
