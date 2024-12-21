package com.mach.gerenciadorpedidos.manager;

import com.mach.gerenciadorpedidos.model.Product;
import com.mach.gerenciadorpedidos.model.User;
import com.mach.gerenciadorpedidos.repository.ProductRepository;
import com.mach.gerenciadorpedidos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserManager {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private UserRepository userRepository;

    public UserManager(UserRepository repository) {
        this.userRepository = repository;
    }

    public void menu() {

        while (true) {
            var msg = """
                    1 - Cadastrar usuário
                    2 - Procurar usuários
                    
                    9 - Listar usuários
                    0 - Sair
                    """;

            System.out.println(msg);
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    addUser();
                    return;
                case 9:
                    searchUsers();
                    return;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public void addUser() {
        System.out.println("Qual o nome do usuário a ser adicionado?");
        String nome = scanner.nextLine();

        System.out.println("Qual o CPF do usuário cadastrado?");
        String cpf = scanner.nextLine();

        System.out.println("Qual a senha do usuário adicionado?");
        String senha = scanner.nextLine();

        User user = new User(nome, cpf, senha);

        Optional<User> existingUser = userRepository.findUserByCpfEquals(user.getCpf());
        userRepository.save(existingUser.orElse(user));
    }

    public void searchUsers() {
        List<User> users = userRepository.findAll();

        users.stream()
                .sorted(Comparator.comparing(User::getId))
                .forEach(System.out::println);
    }
}
