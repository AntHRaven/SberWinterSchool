package sber.winter.school.sberwinterschool.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.ShopDto;
import sber.winter.school.sberwinterschool.model.Shop;

@Component
public class ShopMapper extends GenericMapper<Shop, ShopDto> {

  protected ShopMapper(ModelMapper mapper) {
    super(mapper, Shop.class, ShopDto.class);
  }
}
