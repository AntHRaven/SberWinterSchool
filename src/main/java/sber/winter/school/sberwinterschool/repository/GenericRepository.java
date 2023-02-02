package sber.winter.school.sberwinterschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import sber.winter.school.sberwinterschool.model.GenericModel;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Long> {

}
