package com.mach.gerenciadorpedidos.manager;

import com.mach.gerenciadorpedidos.model.Categories;
import com.mach.gerenciadorpedidos.model.Product;
import com.mach.gerenciadorpedidos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductManager {

    @Autowired
    private ProductRepository repository;

    Scanner scanner = new Scanner(System.in);

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct() {

        System.out.println("Digite o nome do produto desejado:");
        var inputName = scanner.nextLine();

        System.out.println("Selecione uma das categorias abaixo: ");
        System.out.println(Arrays.toString(Categories.values()));

        var category = Categories.valueOf(scanner.nextLine());

        System.out.println("Digite o valor do produto: ");
        var price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a descrição do produto: ");
        String desc = scanner.nextLine();

        Product product = new Product(inputName, category, price, desc);

        Optional<Product> existingProduct = repository.findProductByNomeEqualsIgnoreCase(product.getNome());
        repository.save(existingProduct.orElse(product));
    }

    public void findProduct() {

        System.out.println("Selecione o tipo de informação que utilizará para encontrar o produto (Nome/ID):");
        var input = scanner.nextLine();
        List<Product> products = repository.findAll();

        while (!input.equalsIgnoreCase("sair")) {

            if (input.equalsIgnoreCase("id")) {
                System.out.println("Informe o ID do produto selecionado.");
                Long id = scanner.nextLong();

                if (repository.existsById(id)) {
                    products.stream()
                            .filter(e -> e.getId().equals(id))
                            .forEach(System.out::println);
                } else {
                    System.out.println("Insira um ID válido.");
                    return;
                }
            } else if (input.equalsIgnoreCase("nome")) {
                System.out.println("Informe o nome do produto selecionado.");
                String name = scanner.nextLine();

                if (repository.existsProductByNomeEqualsIgnoreCase(name)) {
                    products.stream()
                            .filter(e -> e.getNome().equalsIgnoreCase(name))
                            .forEach(System.out::println);
                } else {
                    System.out.println("Insira um nome válido.");
                    return;
                }
            } else {
                System.out.println("Escolha uma opção válida.");
                return;
            }
        }
    }

    public void listProducts() {
        List<Product> products = repository.findAll();

        products.stream()
                .sorted(Comparator.comparing(Product::getId))
                .forEach(System.out::println);
    }
}