package sber.winter.school.sberwinterschool.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopDto extends GenericDto {
  private String title;
  private String address;
  private Long organizationId;
  private List<Long> terminalsId;
}
