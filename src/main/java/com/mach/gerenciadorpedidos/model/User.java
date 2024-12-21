package com.mach.gerenciadorpedidos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "\"user_pedido\"",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id")
    )
    private List<Order> pedidosList;

    public User(String name, String cpf, String senha) {
        this.name = name;
        this.cpf = cpf;
        this.senha = senha;
    }

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Order> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Order> pedidosList) {
        this.pedidosList = pedidosList;
    }

    @Override
    public String toString() {
        return "\nID: " + getId() +
                "\nNome: " + getName() +
                "\nCPF: " + getCpf() +
                "\nLista de pedidos: " + getPedidosList();
    }
}
