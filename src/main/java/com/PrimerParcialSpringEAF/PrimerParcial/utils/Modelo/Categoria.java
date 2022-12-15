package com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categoria")

public class Categoria {
    // Creación del Id
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private  String nombreca;
    @Column(nullable = false,length = 500)
    private String descripcionca;

}
