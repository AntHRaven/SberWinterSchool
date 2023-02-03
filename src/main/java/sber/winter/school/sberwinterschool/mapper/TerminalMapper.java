package sber.winter.school.sberwinterschool.mapper;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sber.winter.school.sberwinterschool.dto.TerminalDto;
import sber.winter.school.sberwinterschool.model.GenericModel;
import sber.winter.school.sberwinterschool.model.Terminal;
import sber.winter.school.sberwinterschool.repository.ShopRepository;
import sber.winter.school.sberwinterschool.repository.TransactionalHistoryRepository;

@Component
public class TerminalMapper extends GenericMapper<Terminal, TerminalDto> {
  private final ModelMapper mapper;
  private final TransactionalHistoryRepository transactionalHistoryRepository;
  private final ShopRepository shopRepository;

  protected TerminalMapper(ModelMapper mapper, TransactionalHistoryRepository transactionalHistoryRepository, ShopRepository shopRepository) {
    super(mapper, Terminal.class, TerminalDto.class);
    this.mapper = mapper;
    this.transactionalHistoryRepository = transactionalHistoryRepository;
    this.shopRepository = shopRepository;
  }

  @PostConstruct
  public void setupMapper() {
    mapper.createTypeMap(Terminal.class, TerminalDto.class)
        .addMappings(m -> m.skip(TerminalDto::setTransactionalHistoriesId)).setPostConverter(toDtoConverter())
        .addMappings(m -> m.skip(TerminalDto::setShopId)).setPostConverter(toDtoConverter());
    mapper.createTypeMap(TerminalDto.class, Terminal.class)
        .addMappings(m -> m.skip(Terminal::setTransactionalHistories)).setPostConverter(toEntityConverter())
        .addMappings(m -> m.skip(Terminal::setShop)).setPostConverter(toEntityConverter());
  }

  @Override
  void mapSpecificFields(TerminalDto source, Terminal destination) {
    if (!Objects.isNull(source.getTransactionalHistoriesId())) {
      destination.setTransactionalHistories(transactionalHistoryRepository.findAllByIdIn(source.getTransactionalHistoriesId()));
    } else {
      destination.setTransactionalHistories(null);
    }

    if (!Objects.isNull(source.getShopId())) {
      destination.setShop(shopRepository.findById(source.getShopId()).orElseThrow());
    } else {
      destination.setShop(null);
    }
  }

  @Override
  void mapSpecificFields(Terminal source, TerminalDto destination) {
    destination.setTransactionalHistoriesId(getIds(source));
    destination.setShopId(source.getShop().getId());
  }

  private List<Long> getIds(Terminal author) {
    return Objects.isNull(author) || Objects.isNull(author.getId())
        ? null
        : author.getTransactionalHistories().stream()
            .map(GenericModel::getId)
            .collect(Collectors.toList());
  }
}
