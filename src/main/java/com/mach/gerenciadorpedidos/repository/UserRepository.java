package com.mach.gerenciadorpedidos.repository;

import com.mach.gerenciadorpedidos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByCpfEquals(String cpf);
    
    List<User> findUsersById(Long id);
}
