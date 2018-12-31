package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Badge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public interface BadgeRepository extends CrudRepository<Badge, Long> {
  
  public Application findByApplication(Application application);

  public List<Badge> findAll();

}
