package br.edu.criptosenhajava.repository;

import br.edu.criptosenhajava.model.UserModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Integer> {

	public Optional<UserModel> findByLogin(String login);
}
