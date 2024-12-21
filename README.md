# Gerenciador de Pedidos

## Descrição
O Gerenciador de Pedidos é uma aplicação Java desenvolvida com Spring Boot que permite gerenciar produtos e pedidos (em breve). A aplicação oferece funcionalidades para cadastrar, listar e buscar produtos, além de gerenciar pedidos.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Maven
- JPA (Java Persistence API)
- H2 Database (para testes)

## Estrutura do Projeto
- `src/main/java/com/mach/gerenciadorpedidos/manager`: Contém as classes de gerenciamento (`AppManager`, `ProductManager`).
- `src/main/java/com/mach/gerenciadorpedidos/model`: Contém as classes de modelo (`Product`, `Pedido`, `Categories`).
- `src/main/java/com/mach/gerenciadorpedidos/repository`: Contém as interfaces de repositório (`ProductRepository`).

## Funcionalidades
- **Cadastrar Produto**: Permite cadastrar um novo produto com nome, categoria, preço e descrição.
- **Listar Produtos**: Lista todos os produtos cadastrados.
- **Buscar Produto**: Permite buscar um produto pelo nome ou ID.
- **Gerenciar Pedidos**: Permite gerenciar pedidos (em desenvolvimento).

## Como Executar
1. Clone o repositório:
    ```sh
    git clone <URL_DO_REPOSITORIO>
    cd gerenciador-pedidos
    ```

2. Compile e execute a aplicação:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

3. A aplicação estará disponível em `http://localhost:8080`.

## Exemplos de Uso
### Cadastrar Produto
1. Execute a aplicação.
2. No menu principal, selecione a opção "1 - Cadastrar produto".
3. Siga as instruções para inserir o nome, categoria, preço e descrição do produto.

### Listar Produtos
1. Execute a aplicação.
2. No menu principal, selecione a opção "2 - Listar produtos".

### Buscar Produto
1. Execute a aplicação.
2. No menu principal, selecione a opção "3 - Buscar produto".
3. Escolha buscar por nome ou ID e insira o valor correspondente.

## Contribuição
1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Crie um Pull Request.

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.