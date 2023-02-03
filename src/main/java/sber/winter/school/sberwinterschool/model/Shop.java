package sber.winter.school.sberwinterschool.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Shop
      extends GenericModel {

    @Column
    private String title;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey(name = "FK_SHOP_ORG"))
    private Organization organization;

    @OneToMany(mappedBy = "shop")
    private List<Terminal> terminals;
}
