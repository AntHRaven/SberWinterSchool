package sber.winter.school.sberwinterschool.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.OrganizationDto;
import sber.winter.school.sberwinterschool.model.Organization;

@Component
public class OrganizationMapper extends GenericMapper<Organization, OrganizationDto> {

  protected OrganizationMapper(ModelMapper mapper) {
    super(mapper, Organization.class, OrganizationDto.class);
  }
}
