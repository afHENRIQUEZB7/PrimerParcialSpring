package com.PrimerParcialSpringEAF.PrimerParcial.Repository;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

    List<Articulo> findAllByCodigo(String codigo);


}
