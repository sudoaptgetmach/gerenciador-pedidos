package com.mach.gerenciadorpedidos.manager;

import com.mach.gerenciadorpedidos.repository.OrderRepository;
import com.mach.gerenciadorpedidos.repository.ProductRepository;
import com.mach.gerenciadorpedidos.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppManager {

    Scanner scanner = new Scanner(System.in);
    private final ProductManager productManager;
    private final UserManager userManager;
    private final OrderManager orderManager;

    public AppManager(ProductRepository repository, UserRepository userRepository, OrderRepository orderRepository) {
        this.productManager = new ProductManager(repository);
        this.userManager = new UserManager(userRepository);
        this.orderManager = new OrderManager(orderRepository, userRepository, repository);
    }

    public void menu() {
        while (true) {
            var msg = """
                  1 - Gerenciar produtos
                  2 - Gerenciar usuários
                  3 - Gerenciar pedidos
                  
                  0 - Sair
                  """;

            System.out.println(msg);
            var input = scanner.nextInt();

            switch (input) {
                case 1:
                    productManager.menu();
                    break;
                case 2:
                    userManager.menu();
                    break;
                case 3:
                    orderManager.menu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}