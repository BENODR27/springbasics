package beno.dev.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import beno.dev.springdemo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
