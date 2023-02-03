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
public class OrganizationDto extends GenericDto{
  private String title;
  private String owner;
  private List<Long> shopsId;

}
