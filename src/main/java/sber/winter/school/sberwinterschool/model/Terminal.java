package sber.winter.school.sberwinterschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "terminals")
@SequenceGenerator(name = "default_generator", sequenceName = "term_seq", allocationSize = 1)
public class Terminal extends GenericModel {
  @Column
  private String serialNumber;

  @Column
  private String bank;

  @Column
  private String model;

  @Column
  private String responsiblePerson;

  @OneToMany
  private List<TransactionalHistory> transactionalHistories;
}
