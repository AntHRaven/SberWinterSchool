package sber.winter.school.sberwinterschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
@Table(name = "organizations")
@SequenceGenerator(name = "default_generator", sequenceName = "org_seq", allocationSize = 1)
public class Organization extends GenericModel{

  @Column
  private String title;

  @Column
  private String owner;

  @OneToMany
  private List<Shop> shops;
}
