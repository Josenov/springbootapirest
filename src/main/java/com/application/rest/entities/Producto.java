package com.application.rest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio; //decimal de alta presicion para trabajar con dinero

    @ManyToOne
    @JoinColumn(name="id_fabricante")
    private Fabricante fabricante;
}
