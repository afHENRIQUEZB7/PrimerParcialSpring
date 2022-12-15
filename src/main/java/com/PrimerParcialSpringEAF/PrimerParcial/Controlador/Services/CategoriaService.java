package com.PrimerParcialSpringEAF.PrimerParcial.Controlador.Services;

import com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo.Categoria;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<Categoria> crearCategorias(Categoria categoria);

    ResponseEntity<Categoria> getCategoria(Long id);

    ResponseEntity<Categoria> ListarTodosLasCategorias();

}
