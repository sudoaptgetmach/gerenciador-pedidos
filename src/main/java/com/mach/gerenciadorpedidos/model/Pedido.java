package com.mach.gerenciadorpedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Pedido {

    @Id
    Long id;
    LocalDate date;

}
