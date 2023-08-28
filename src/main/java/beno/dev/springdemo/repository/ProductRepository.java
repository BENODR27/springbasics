package beno.dev.springdemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import beno.dev.springdemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}

