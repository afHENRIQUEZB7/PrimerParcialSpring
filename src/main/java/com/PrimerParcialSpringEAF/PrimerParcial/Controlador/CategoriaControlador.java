package com.PrimerParcialSpringEAF.PrimerParcial.Controlador;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Categoria;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.CategoriaRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CategoriaControlador {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;


    // Agregar Categorias nuevos
    @PostMapping(value = "/categoria")
    public ResponseEntity crearCategorias(@RequestBody Categoria categoria){
        return categoriaService.crearCategorias(categoria);

    }

    // Mostrar las Categorias por Id
    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity getCategoria(@PathVariable Long id){
        return categoriaService.getCategoria(id);
    }


    // Moatrar todas las Categorias
    @GetMapping("/categorias")
    public ResponseEntity ListarTodosLasCategorias(){
        return categoriaService.ListarTodosLasCategorias();
    }


}
