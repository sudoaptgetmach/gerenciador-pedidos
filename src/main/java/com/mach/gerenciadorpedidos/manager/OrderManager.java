package com.mach.gerenciadorpedidos.manager;

import com.mach.gerenciadorpedidos.model.Order;
import com.mach.gerenciadorpedidos.model.Product;
import com.mach.gerenciadorpedidos.model.User;
import com.mach.gerenciadorpedidos.repository.OrderRepository;
import com.mach.gerenciadorpedidos.repository.ProductRepository;
import com.mach.gerenciadorpedidos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class OrderManager {

    Scanner scanner = new Scanner(System.in);

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    public OrderManager(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void menu() {
        while (true) {
            var msg = """
                    1 - Cadastrar pedidos
                    2 - Procurar pedidos
                    
                    9 - Listar pedidos
                    0 - Sair
                    """;

            System.out.println(msg);
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1 -> createOrder();
                case 2 -> System.out.println("Nothing here. :)");
                case 9 -> fetchAllOrders();
                default -> System.out.println("Digite uma opção válida.");

            }
        }
    }

    public void createOrder() {

        LocalDate date = LocalDate.now();
        List<Product> productList = new ArrayList<>();

        System.out.println("Qual o CPF do usuário cadastrado?");
        Optional<User> compradorOpt = userRepository.findUserByCpfEquals(scanner.nextLine());

        if (compradorOpt.isEmpty()) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        User comprador = compradorOpt.get();

        System.out.println("Qual é o endereço de entrega?");
        String endereco = scanner.nextLine();

        while (true) {
            System.out.println("Digite o nome do produto para adicionar (ou 'sair' para finalizar):");
            String produtoInput = scanner.nextLine();

            if (produtoInput.equalsIgnoreCase("sair")) {
                break;
            }

            Optional<Product> productOpt = productRepository.findProductByNomeEqualsIgnoreCase(produtoInput);
            if (productOpt.isEmpty()) {
                System.out.println("Produto não encontrado.");
            } else {
                Product produto = productOpt.get();
                if (!productList.contains(produto)) {
                    productList.add(produto);
                } else {
                    System.out.println("Produto já adicionado.");
                }
            }
        }

        Order order = new Order(date, comprador, endereco, productList);
        orderRepository.save(order);

        comprador.getPedidosList().add(order);
        userRepository.save(comprador);

        System.out.println("Pedido criado com sucesso.");
    }

    public void fetchAllOrders() {
        List<Order> orders = orderRepository.findAll();

        orders.stream()
                .sorted(Comparator.comparing(Order::getId))
                .forEach(System.out::println);
    }
}
