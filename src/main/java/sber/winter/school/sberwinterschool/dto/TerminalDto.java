package sber.winter.school.sberwinterschool.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TerminalDto extends GenericDto {

  private String serialNumber;
  private String bank;
  private String model;
  private String responsiblePerson;
  private List<Long> transactionalHistoriesId;

}
