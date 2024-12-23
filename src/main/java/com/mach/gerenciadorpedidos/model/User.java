package com.mach.gerenciadorpedidos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos")
    @Column(unique = true, nullable = false)
    private String cpf;

    @NotBlank
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "comprador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> pedidosList;

    public User(String name, String cpf, String senha) {
        this.name = name;
        this.cpf = cpf;
        this.senha = senha;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "\nQuantidade de pedidos: " + (pedidosList != null ? pedidosList.size() : 0);
    }
}