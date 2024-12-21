package com.mach.gerenciadorpedidos.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categories categories;

    @Column(name = "valor")
    private Double preco;

    private String descricao;

    public Product() {
    }

    public Product(String nome, Categories categories, Double preco, String descricao) {
        this.nome = nome;
        this.categories = categories;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "\nID: " + getId() +
               "\nNome: " + getNome() +
               "\nDescrição: " + getDescricao() +
               "\nPreço: " + getPreco();
    }
}
