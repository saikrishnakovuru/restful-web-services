package com.in28minutes.springboot.restfulwedservices.user;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.restfulwedservices.jpa.PostReposetory;
import com.in28minutes.springboot.restfulwedservices.jpa.UserReposetory;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	@Autowired
	private UserReposetory userRepo;
	@Autowired
	private PostReposetory postRepo;

	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/jpa/users/{userId}")
	public EntityModel<User> RetriveUserById(@PathVariable int userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user == null)
			throw new UserNotFoundException("user: " + userId);

		EntityModel<User> entityModel = EntityModel.of(user.get());

		WebMvcLinkBuilder link = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userRepo.deleteById(userId);
	}

	@GetMapping("/jpa/users/{userId}/posts")
	public List<Post> retrivePostsForAnUser(@PathVariable int userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user == null)
			throw new UserNotFoundException("user: " + userId);

		return user.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = userRepo.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);

		post.setUser(user.get());

		Post savedPost = postRepo.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
