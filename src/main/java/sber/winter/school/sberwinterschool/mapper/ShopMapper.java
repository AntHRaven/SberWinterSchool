package sber.winter.school.sberwinterschool.mapper;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.ShopDto;
import sber.winter.school.sberwinterschool.model.GenericModel;
import sber.winter.school.sberwinterschool.model.Shop;
import sber.winter.school.sberwinterschool.repository.OrganizationRepository;
import sber.winter.school.sberwinterschool.repository.TerminalRepository;

@Component
public class ShopMapper extends GenericMapper<Shop, ShopDto> {

  private final ModelMapper mapper;
  private final TerminalRepository terminalRepository;
  private final OrganizationRepository organizationRepository;

  protected ShopMapper(ModelMapper mapper, TerminalRepository terminalRepository, OrganizationRepository organizationRepository) {
    super(mapper, Shop.class, ShopDto.class);
    this.mapper = mapper;
    this.terminalRepository = terminalRepository;
    this.organizationRepository = organizationRepository;
  }

  @PostConstruct
  public void setupMapper() {
    mapper.createTypeMap(Shop.class, ShopDto.class)
        .addMappings(m -> m.skip(ShopDto::setTerminalsId)).setPostConverter(toDtoConverter())
        .addMappings(m -> m.skip(ShopDto::setOrganizationId)).setPostConverter(toDtoConverter());
    mapper.createTypeMap(ShopDto.class, Shop.class)
        .addMappings(m -> m.skip(Shop::setTerminals)).setPostConverter(toEntityConverter());
  }

  @Override
  void mapSpecificFields(ShopDto source, Shop destination) {
    if (!Objects.isNull(source.getTerminalsId())) {
      destination.setTerminals(terminalRepository.findAllByIdIn(source.getTerminalsId()));
    } else {
      destination.setTerminals(null);
    }
    if(!Objects.isNull(source.getOrganizationId())) {
      destination.setOrganization(organizationRepository.findById(source.getOrganizationId()).orElseThrow());
    }
  }

  @Override
  void mapSpecificFields(Shop source, ShopDto destination) {
    destination.setOrganizationId(source.getOrganization().getId());
    destination.setTerminalsId(getIds(source));
  }

  private List<Long> getIds(Shop author) {
    return Objects.isNull(author) || Objects.isNull(author.getId())
        ? null
        : author.getTerminals().stream()
            .map(GenericModel::getId)
            .collect(Collectors.toList());
  }
}
