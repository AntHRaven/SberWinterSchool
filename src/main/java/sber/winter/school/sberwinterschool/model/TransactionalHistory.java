package sber.winter.school.sberwinterschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shops")
@SequenceGenerator(name = "default_generator", sequenceName = "trans_seq", allocationSize = 1)
public class TransactionalHistory extends GenericModel{

  @Column
  private LocalDateTime transactionalDate;

  @Column
  private Double total;
}
