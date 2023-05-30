package br.edu.criptosenhajava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.criptosenhajava.model.UserModel;
import br.edu.criptosenhajava.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {  this.userRepository = userRepository; }
	
	
	@GetMapping
	public ResponseEntity<List<UserModel>> listAll() { return ResponseEntity.ok(userRepository.findAll()); }
	
	@PostMapping
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) { return ResponseEntity.ok(userRepository.save(user)); }
	
	
}
