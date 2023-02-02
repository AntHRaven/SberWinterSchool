package sber.winter.school.sberwinterschool.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sber.winter.school.sberwinterschool.dto.ShopDto;
import sber.winter.school.sberwinterschool.mapper.GenericMapper;
import sber.winter.school.sberwinterschool.model.Shop;
import sber.winter.school.sberwinterschool.service.GenericService;

@RestController
@RequestMapping("/shop")
@Tag(name = "Магазины",
     description = "Контроллер для работы с магазинами(точками)")
public class ShopController extends GenericController<Shop, ShopDto> {

  protected ShopController(GenericService<Shop> service,
      GenericMapper<Shop, ShopDto> mapper) {
    super(service, mapper);
  }
}
