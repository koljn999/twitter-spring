package twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twitter.models.UserTest;

@Repository
public interface UserRepository extends JpaRepository<UserTest, Long> {

public UserTest findUserByUsername (String userName);

}
