package com.PrimerParcialSpringEAF.PrimerParcial.Services;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Categoria;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<Categoria> crearCategorias(Categoria categoria);

    ResponseEntity<Categoria> getCategoria(Long id);

    ResponseEntity<Categoria> ListarTodosLasCategorias();

}
