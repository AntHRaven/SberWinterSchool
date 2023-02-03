package sber.winter.school.sberwinterschool.mapper;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.TransactionalHistoryDto;
import sber.winter.school.sberwinterschool.dto.TransactionalHistoryDto;
import sber.winter.school.sberwinterschool.model.GenericModel;
import sber.winter.school.sberwinterschool.model.TransactionalHistory;
import sber.winter.school.sberwinterschool.model.TransactionalHistory;
import sber.winter.school.sberwinterschool.repository.ShopRepository;
import sber.winter.school.sberwinterschool.repository.TerminalRepository;
import sber.winter.school.sberwinterschool.repository.TransactionalHistoryRepository;

@Component
public class TransactionalHistoryMapper extends GenericMapper<TransactionalHistory, TransactionalHistoryDto> {

  private final ModelMapper mapper;
  private final TerminalRepository terminalRepository;


  protected TransactionalHistoryMapper(ModelMapper mapper,
      TerminalRepository terminalRepository) {
    super(mapper, TransactionalHistory.class, TransactionalHistoryDto.class);
    this.mapper = mapper;
    this.terminalRepository = terminalRepository;
  }


  @PostConstruct
  public void setupMapper() {
    mapper.createTypeMap(TransactionalHistory.class, TransactionalHistoryDto.class)
        .addMappings(m -> m.skip(TransactionalHistoryDto::setTerminalId)).setPostConverter(toDtoConverter());
    mapper.createTypeMap(TransactionalHistoryDto.class, TransactionalHistory.class)
        .addMappings(m -> m.skip(TransactionalHistory::setTerminal)).setPostConverter(toEntityConverter());
  }

  @Override
  void mapSpecificFields(TransactionalHistoryDto source, TransactionalHistory destination) {
    if (!Objects.isNull(source.getTerminalId())) {
      destination.setTerminal(terminalRepository.findById(source.getTerminalId()).orElseThrow());
    } else {
      destination.setTerminal(null);
    }


  }

  @Override
  void mapSpecificFields(TransactionalHistory source, TransactionalHistoryDto destination) {
    destination.setTerminalId(source.getTerminal().getId());
  }

}
