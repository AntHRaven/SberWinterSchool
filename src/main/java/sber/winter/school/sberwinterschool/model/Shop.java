package sber.winter.school.sberwinterschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shops")
@SequenceGenerator(name = "default_generator", sequenceName = "shops_seq", allocationSize = 1)
public class Shop extends GenericModel {

  @Column
  private String title;

  @Column
  private String address;

  @OneToMany
  private List<Terminal> terminals;
}
