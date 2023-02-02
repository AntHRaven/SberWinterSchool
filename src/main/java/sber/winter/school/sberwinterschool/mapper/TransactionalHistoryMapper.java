package sber.winter.school.sberwinterschool.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.TransactionalHistoryDto;
import sber.winter.school.sberwinterschool.model.TransactionalHistory;

@Component
public class TransactionalHistoryMapper extends GenericMapper<TransactionalHistory, TransactionalHistoryDto> {

  protected TransactionalHistoryMapper(ModelMapper mapper) {
    super(mapper, TransactionalHistory.class, TransactionalHistoryDto.class);
  }
}
