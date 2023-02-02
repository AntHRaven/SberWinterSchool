package sber.winter.school.sberwinterschool.mapper;

import java.util.List;
import sber.winter.school.sberwinterschool.dto.GenericDto;
import sber.winter.school.sberwinterschool.model.GenericModel;

public interface Mapper<E extends GenericModel, D extends GenericDto> {

  E toEntity(D dto);
  List<E> toEntities(List<D> dtos);

  D toDto(E entity);
  List<D> toDtos(List<E> entities);



}
