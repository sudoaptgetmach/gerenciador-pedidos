package com.mach.gerenciadorpedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "orderslist")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate date;

    String endereco;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User comprador;

    public Order(LocalDate date, User comprador, String endereco, List<Product> productList) {
        this.date = date;
        this.comprador = comprador;
        this.endereco = endereco;
        this.productList = productList;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getComprador() {
        return comprador;
    }

    public void setComprador(User comprador) {
        this.comprador = comprador;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "\nID: " + getId() +
                "\nData: " + getDate() +
                "\nComprador: " + getComprador() +
                "\nProdutos: " + getProductList();
    }
}
