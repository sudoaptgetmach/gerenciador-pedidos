package com.mach.gerenciadorpedidos.model;

public enum Categories {
    ELETRO("Eletrônicos"),
    MODA("Moda e Acessórios"),
    BELEZA("Beleza e saúde"),
    ESPORTES("Esportes e Lazer"),
    CASA("Casa e Cozinha");

    private final String nome;

    Categories(String nome) {
        this.nome = nome;
    }

}