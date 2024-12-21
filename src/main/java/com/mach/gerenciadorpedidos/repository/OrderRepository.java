package com.mach.gerenciadorpedidos.repository;

import com.mach.gerenciadorpedidos.model.Order;
import com.mach.gerenciadorpedidos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderByCompradorAndIdEquals(User comprador, Long id);
}
