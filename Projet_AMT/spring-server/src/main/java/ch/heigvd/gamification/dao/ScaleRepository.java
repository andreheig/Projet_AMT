package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Scale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScaleRepository extends CrudRepository<Scale, Long> {
  
  List<Scale> findByApp(Application application);

  Scale findByNameAndApp(String Name, Application application);

  List<Scale> findAll();

}
