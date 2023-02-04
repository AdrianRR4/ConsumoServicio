package com.dev21.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev21.test.dto.UserResponse;
import com.dev21.test.service.UserService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

//	private final UserService userService = new UserService();

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<UserResponse>> getUsers() {

		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void crearUser(@RequestBody UserResponse user) {

		userService.createUser(user);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editUser(@PathVariable(value = "id") Integer id, @RequestBody UserResponse user) {

		userService.updateUser(id, user);

	}

	@DeleteMapping("/{id}")
	public void deletUser(@PathVariable(value = "id") Integer id) {

		userService.deleteUser(id);

	}

}
