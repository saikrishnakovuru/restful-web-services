package com.in28minutes.springboot.restfulwedservices.user;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.net.URI;
import java.util.List;

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

import jakarta.validation.Valid;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{userId}")
	public EntityModel<User> RetriveUserById(@PathVariable int userId) {
		User user = userDaoService.retriveUserById(userId);
		if (user == null)
			throw new UserNotFoundException("user: " + userId);

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		User user = userDaoService.deleteUser(userId);
		if (user == null)
			throw new UserNotFoundException("user: " + userId);
	}

//	@GetMapping("/users/{userId}")
//	public User RetriveUser(@PathVariable int userId) {
//		User user = userDaoService.retriveUserById(userId);
//		if (user == null)
//			throw new UserNotFoundException("user: " + userId);
//		return user;
//	}
}
