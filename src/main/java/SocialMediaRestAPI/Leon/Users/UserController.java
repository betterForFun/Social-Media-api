package SocialMediaRestAPI.Leon.Users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import SocialMediaRestAPI.Leon.UserRepository;
import SocialMediaRestAPI.Leon.postsRepository;
import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private postsRepository postsRepository;
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException(id + " User not Found");
		}
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("All-Users"));
		return entityModel;
	}
	

	@PostMapping("/users")
	public ResponseEntity<User> insertUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getUserPost(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException(id + " User not Found");
		}
		return user.get().getPosts();
	}
	
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Post> insertPost(@PathVariable Integer id,@Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException(id + " User not Found");
		}
		
		post.setUser(user.get());
		Post savedPost = postsRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
	
	
	

}
