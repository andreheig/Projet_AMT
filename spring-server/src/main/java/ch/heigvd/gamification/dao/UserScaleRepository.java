package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.EndUser;
import ch.heigvd.gamification.model.Scale;
import ch.heigvd.gamification.model.UserScale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserScaleRepository extends CrudRepository<UserScale, Long> {
    UserScale findByUserAndScale(EndUser endUser, Scale scale);
}
