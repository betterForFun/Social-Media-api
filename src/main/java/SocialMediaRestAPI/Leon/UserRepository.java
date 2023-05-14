package SocialMediaRestAPI.Leon;

import org.springframework.data.jpa.repository.JpaRepository;
import SocialMediaRestAPI.Leon.Users.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}