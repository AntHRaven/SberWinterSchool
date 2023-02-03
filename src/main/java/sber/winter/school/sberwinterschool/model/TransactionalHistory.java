package sber.winter.school.sberwinterschool.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

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
@Table(name = "transaction_history")
@SequenceGenerator(name = "default_generator", sequenceName = "trans_seq", allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class TransactionalHistory extends GenericModel{

  @Column
  private LocalDateTime transactionalDate;

  @Column
  private Double total;

  @ManyToOne
  @JoinColumn(name = "terminal_id", foreignKey = @ForeignKey(name = "FK_HISTORY_TERMINAL"))
  private Terminal terminal;
}
