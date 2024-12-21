package com.mach.gerenciadorpedidos.manager;

import com.mach.gerenciadorpedidos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppManager {

    Scanner scanner = new Scanner(System.in);
    private final ProductManager manager;

    public AppManager(ProductRepository repository) {
        this.manager = new ProductManager(repository);
    }

    public void menu() {
        while (true) {
            var msg = """
                  1 - Cadastrar produto
                  2 - Procurar produtos
                  
                  9 - Listar produtos
                  0 - Sair
                  """;

            System.out.println(msg);
            var input = scanner.nextInt();

            switch (input) {
                case 1:
                    manager.createProduct();
                    break;
                case 2:
                    manager.findProduct();
                    break;
                case 9:
                    manager.listProducts();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}