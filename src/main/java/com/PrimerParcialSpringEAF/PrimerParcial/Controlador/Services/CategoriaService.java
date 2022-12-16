package com.PrimerParcialSpringEAF.PrimerParcial.Controlador.Services;

import com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo.Categoria;
import com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo.Usuario;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<Categoria> crearCategorias(Categoria categoria);

    ResponseEntity<Categoria> getCategoria(Long id);

    ResponseEntity<Categoria> ListarTodosLasCategorias();

    ResponseEntity<Categoria> modificarCategoria(Long id, Categoria categoria);

    ResponseEntity<Categoria> eliminarCategoria(Long id);

}
