package sber.winter.school.sberwinterschool.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

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
@AttributeOverride(name = "id", column = @Column(name="serial_number"))
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Terminal extends GenericModel {

  @Column
  private String bank;

  @Column
  private String model;

  @Column
  private String responsiblePerson;

  @ManyToOne
  @JoinColumn(name = "shop_id", foreignKey = @ForeignKey(name = "FK_TERMINAL_SHOP"))
  private Shop shop;

  @OneToMany(mappedBy = "terminal")
  private List<TransactionalHistory> transactionalHistories;
}
