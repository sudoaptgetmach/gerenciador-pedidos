package com.mach.gerenciadorpedidos.repository;

import com.mach.gerenciadorpedidos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByNomeContainingIgnoreCase(String nome);

    Optional<Product> findProductByNomeEqualsIgnoreCase(String nome);

    List<Product> findProductById(Long id);

    String nome(String nome);

    boolean existsProductByNomeEqualsIgnoreCase(String name);
}
