package sber.winter.school.sberwinterschool.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sber.winter.school.sberwinterschool.dto.OrganizationDto;
import sber.winter.school.sberwinterschool.mapper.GenericMapper;
import sber.winter.school.sberwinterschool.model.Organization;
import sber.winter.school.sberwinterschool.model.Shop;
import sber.winter.school.sberwinterschool.repository.OrganizationRepository;
import sber.winter.school.sberwinterschool.repository.ShopRepository;
import sber.winter.school.sberwinterschool.service.GenericService;

@RestController
@RequestMapping("/organization")
@Tag(name = "Организации",
     description = "Контроллер для работы с организациями")
public class OrganizationController extends GenericController<Organization, OrganizationDto> {

  private final OrganizationRepository repository;
  private final ShopRepository shopRepository;
  protected OrganizationController(GenericService<Organization> service,
      GenericMapper<Organization, OrganizationDto> mapper, OrganizationRepository repository, ShopRepository shopRepository) {
    super(service, mapper);
    this.repository = repository;
    this.shopRepository = shopRepository;
  }

  @GetMapping("/add-shop/{shopId}/{orgId}")
  public ResponseEntity<?> addShop(@PathVariable Long orgId, @PathVariable Long shopId) {

    Organization organization = repository.findById(orgId).orElseThrow();
    Shop shop = shopRepository.findById(shopId).orElseThrow();

    organization.getShops().add(shop);
    return ResponseEntity.ok(repository.save(organization));

  }
}
