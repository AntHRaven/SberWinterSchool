package sber.winter.school.sberwinterschool.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sber.winter.school.sberwinterschool.dto.OrganizationDto;
import sber.winter.school.sberwinterschool.mapper.GenericMapper;
import sber.winter.school.sberwinterschool.model.Organization;
import sber.winter.school.sberwinterschool.service.GenericService;

@RestController
@RequestMapping("/organization")
@Tag(name = "Организации",
     description = "Контроллер для работы с организациями")
public class OrganizationController extends GenericController<Organization, OrganizationDto> {

  protected OrganizationController(GenericService<Organization> service,
      GenericMapper<Organization, OrganizationDto> mapper) {
    super(service, mapper);
  }
}
