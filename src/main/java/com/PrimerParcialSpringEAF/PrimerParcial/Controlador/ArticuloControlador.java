package com.PrimerParcialSpringEAF.PrimerParcial.Controlador;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.ArticuloRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.Services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ArticuloControlador {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ArticuloService articuloService;

    @GetMapping(value = "/articulo/{id}")
    public ResponseEntity getArticulo(@PathVariable Long id){
      return articuloService.getArticuloId(id);
    }

    // Mostrar los articulos por el Codigo
    @GetMapping(value = "/articulo/codigo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo){
        return articuloService.getArticulo(codigo);
    }


    // Agregar Articulos nuevos
    @PostMapping(value = "/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo){
        return articuloService.crearArticulo(articulo);
    }

    // Visualizar todos los articulos
    @GetMapping("/articulos")
    public ResponseEntity ListarTodosLosArticulos(){
        return articuloService.ListarTodosLosArticulos();
    }



    //Modificación del articulo por el codigo
    @PutMapping("/articulo/codigo/{codigo}")
    public ResponseEntity editarArticulos(@PathVariable String codigo,@RequestBody Articulo articulo){
       return articuloService.editarArticulos(codigo,articulo);
    }


    //Eliminar Articulos
    @DeleteMapping("/articulo/codigo/{codigo}")
    public ResponseEntity eliminarArticulos(@PathVariable String codigo) {
        return articuloService.eliminarArticulos(codigo);
    }








}



