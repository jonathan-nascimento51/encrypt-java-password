package br.edu.criptosenhajava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.criptosenhajava.model.UserModel;
import br.edu.criptosenhajava.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	public UserController(UserRepository userRepository, PasswordEncoder encoder) {  
		this.userRepository = userRepository; 
		this.encoder = encoder; 
	}
		
	@GetMapping
	public ResponseEntity<List<UserModel>> listAll() { return ResponseEntity.ok(userRepository.findAll()); }
	
	@PostMapping
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) { 
		user.setPassword(encoder.encode(user.getPassword()));
		return ResponseEntity.ok(userRepository.save(user)); 
	}
	
	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validPwd(@RequestParam String login,
										    @RequestParam String password){
		
		Optional<UserModel> optUser = userRepository.findByLogin(login);
		if (optUser.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
		UserModel user = optUser.get();
		boolean valid = encoder.matches(password, user.getPassword());
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);
	}
	
	
}
