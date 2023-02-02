package sber.winter.school.sberwinterschool.service;

import org.springframework.stereotype.Service;
import sber.winter.school.sberwinterschool.model.Shop;
import sber.winter.school.sberwinterschool.repository.GenericRepository;

@Service
public class ShopService extends GenericService<Shop> {

  protected ShopService(GenericRepository<Shop> repository) {
    super(repository);
  }
}
