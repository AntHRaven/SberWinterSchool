package sber.winter.school.sberwinterschool.service;

import org.springframework.stereotype.Service;
import sber.winter.school.sberwinterschool.model.Organization;
import sber.winter.school.sberwinterschool.repository.GenericRepository;

@Service
public class OrganizationService extends GenericService<Organization> {

  protected OrganizationService(GenericRepository<Organization> repository) {
    super(repository);
  }
}
