package com.mach.gerenciadorpedidos.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(name = "categoria", nullable = false)
    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column(name = "valor", nullable = false)
    private Double preco;

    @Column(length = 500)
    private String descricao;

    public Product() {
    }

    public Product(String nome, Categories category, Double preco, String descricao) {
        this.nome = nome;
        this.category = category;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nID: " + getId() +
                "\nNome: " + getNome() +
                "\nCategoria: " + getCategory() +
                "\nDescrição: " + getDescricao() +
                "\nPreço: " + getPreco();
    }
}