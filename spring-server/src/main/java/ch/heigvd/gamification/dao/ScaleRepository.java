package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Scale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public interface ScaleRepository extends CrudRepository<Scale, Long> {
  
  public Application findByApplication(Application application);

  public List<Scale> findAll();

}
