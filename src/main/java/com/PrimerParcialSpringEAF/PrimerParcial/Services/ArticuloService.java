package com.PrimerParcialSpringEAF.PrimerParcial.Services;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import org.springframework.http.ResponseEntity;

public interface ArticuloService {

    ResponseEntity<Articulo> getArticuloId(long id);

    ResponseEntity<Articulo> getArticulo(String codigo);

    ResponseEntity<Articulo> crearArticulo(Articulo articulo);

    ResponseEntity<Articulo> ListarTodosLosArticulos();

    ResponseEntity<Articulo> editarArticulos(String codigo, Articulo articulo);

    ResponseEntity<Articulo> eliminarArticulos(String codigo);

}
