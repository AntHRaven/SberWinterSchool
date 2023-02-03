package sber.winter.school.sberwinterschool.dto;

import jakarta.persistence.Column;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionalHistoryDto extends GenericDto{

  private LocalDateTime transactionalDate;
  private Double total;
  private Long terminalId;
}
