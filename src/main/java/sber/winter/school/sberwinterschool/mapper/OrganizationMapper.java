package sber.winter.school.sberwinterschool.mapper;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.OrganizationDto;
import sber.winter.school.sberwinterschool.model.GenericModel;
import sber.winter.school.sberwinterschool.model.Organization;
import sber.winter.school.sberwinterschool.repository.ShopRepository;

@Component
public class OrganizationMapper extends GenericMapper<Organization, OrganizationDto> {

  private final ModelMapper mapper;
  private final ShopRepository shopRepository;

  protected OrganizationMapper(ModelMapper mapper, ShopRepository shopRepository) {
    super(mapper, Organization.class, OrganizationDto.class);
    this.mapper = mapper;
    this.shopRepository = shopRepository;
  }

  @PostConstruct
  public void setupMapper() {
    mapper.createTypeMap(Organization.class, OrganizationDto.class)
        .addMappings(m -> m.skip(OrganizationDto::setShopsId)).setPostConverter(toDtoConverter());
    mapper.createTypeMap(OrganizationDto.class, Organization.class)
        .addMappings(m -> m.skip(Organization::setShops)).setPostConverter(toEntityConverter());
  }

  @Override
  void mapSpecificFields(OrganizationDto source, Organization destination) {
    if (!Objects.isNull(source.getShopsId())) {
      destination.setShops(shopRepository.findAllByIdIn(source.getShopsId()));
    } else {
      destination.setShops(null);
    }
  }

  @Override
  void mapSpecificFields(Organization source, OrganizationDto destination) {
    destination.setShopsId(getIds(source));
  }

  private List<Long> getIds(Organization author) {
    return Objects.isNull(author) || Objects.isNull(author.getId())
        ? null
        : author.getShops().stream()
            .map(GenericModel::getId)
            .collect(Collectors.toList());
  }
}
