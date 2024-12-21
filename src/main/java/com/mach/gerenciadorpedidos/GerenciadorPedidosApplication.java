package com.mach.gerenciadorpedidos;

import com.mach.gerenciadorpedidos.manager.AppManager;
import com.mach.gerenciadorpedidos.repository.OrderRepository;
import com.mach.gerenciadorpedidos.repository.ProductRepository;
import com.mach.gerenciadorpedidos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorPedidosApplication.class, args);
    }

    public void run(String... args) {

        AppManager appManager = new AppManager(repository, userRepository, orderRepository);
        appManager.menu();
    }
}
