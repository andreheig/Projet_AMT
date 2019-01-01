package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import java.util.List;

import ch.heigvd.gamification.model.Badge;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public interface ApplicationRepository extends CrudRepository<Application, Long> {
  
  public Application findByName(String name);

  public Application findByKeyUUID(String uuid);


}
