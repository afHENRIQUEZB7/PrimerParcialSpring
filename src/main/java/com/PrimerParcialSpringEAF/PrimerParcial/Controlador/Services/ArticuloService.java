package com.PrimerParcialSpringEAF.PrimerParcial.Controlador.Services;

import com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo.Articulo;
import org.springframework.http.ResponseEntity;

public interface ArticuloService {

    ResponseEntity<Articulo> getArticuloId(long id);

    ResponseEntity<Articulo> getArticulo(String codigo);

    ResponseEntity<Articulo> crearArticulo(Articulo articulo);

    ResponseEntity<Articulo> ListarTodosLosArticulos();

    ResponseEntity<Articulo> editarArticulos(String codigo, Articulo articulo);

    ResponseEntity<Articulo> eliminarArticulos(String codigo);

}
