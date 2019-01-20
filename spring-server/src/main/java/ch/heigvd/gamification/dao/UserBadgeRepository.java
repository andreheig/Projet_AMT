package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Badge;
import ch.heigvd.gamification.model.EndUser;
import ch.heigvd.gamification.model.UserBadge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBadgeRepository extends CrudRepository<UserBadge, Long> {

    List<UserBadge> findByUserIdInGamifiedApplication(String idInGamifiedApplication);
    UserBadge findByUserAndBadge(EndUser user, Badge badge);

}
