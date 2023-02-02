package sber.winter.school.sberwinterschool.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sber.winter.school.sberwinterschool.model.Organization;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopDto extends GenericDto {
  private String title;
  private String address;
  private OrganizationDto organization;
  private List<Long> terminalsId;
}
