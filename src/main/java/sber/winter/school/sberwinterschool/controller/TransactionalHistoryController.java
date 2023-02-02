package sber.winter.school.sberwinterschool.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sber.winter.school.sberwinterschool.dto.TransactionalHistoryDto;
import sber.winter.school.sberwinterschool.mapper.GenericMapper;
import sber.winter.school.sberwinterschool.model.TransactionalHistory;
import sber.winter.school.sberwinterschool.service.GenericService;

@RestController
@RequestMapping("/transactional-history")
@Tag(name = "История транзакций",
     description = "Контроллер для работы с транзакциями")
public class TransactionalHistoryController extends GenericController<TransactionalHistory, TransactionalHistoryDto> {

  protected TransactionalHistoryController(GenericService<TransactionalHistory> service,
      GenericMapper<TransactionalHistory, TransactionalHistoryDto> mapper) {
    super(service, mapper);
  }
}
