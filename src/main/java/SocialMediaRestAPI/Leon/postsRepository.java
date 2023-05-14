package SocialMediaRestAPI.Leon;

import org.springframework.data.jpa.repository.JpaRepository;

import SocialMediaRestAPI.Leon.Users.Post;

public interface postsRepository extends JpaRepository<Post, Integer>{

}
