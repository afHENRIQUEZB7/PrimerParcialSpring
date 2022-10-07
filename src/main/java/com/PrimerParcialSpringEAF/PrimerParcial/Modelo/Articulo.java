package com.PrimerParcialSpringEAF.PrimerParcial.Modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "articulos")

public class Articulo {
    //Creación de Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //COdigo articulo
    @Column(nullable = false,length = 15)
    private String codigo;
    // Nombre del articulo
    @Column(nullable = false,length = 100)
    private String nombre;
    // Descripción de articulo
    @Column(nullable = false,length = 300)
    private  String descripcion;
    // Fecha del articulo
    private Date fechaarticulo;
    // Categoria del articulo
    private  Categoria categoria;
    // stock del articulo
    @Column(nullable = false)
    private String stock;
    // Pecrio de venta del articulo
    @Column(nullable = false)
    private  Double preciov;
    // Precio de compra del articulo
    @Column(nullable = false)
    private  Double precioc;




}
