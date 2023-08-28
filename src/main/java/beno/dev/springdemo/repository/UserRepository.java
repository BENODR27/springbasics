package beno.dev.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import beno.dev.springdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
