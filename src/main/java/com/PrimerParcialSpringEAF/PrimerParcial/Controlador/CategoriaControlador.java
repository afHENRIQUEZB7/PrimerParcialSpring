package com.PrimerParcialSpringEAF.PrimerParcial.Controlador;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Categoria;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.CategoriaRepository;
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

    // Agregar Categorias nuevos
    @PostMapping(value = "/categoria")
    public ResponseEntity crearCategorias(@RequestBody Categoria categoria){
        try {
            categoriaRepository.save(categoria);
            return new ResponseEntity(categoria, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    // Mostrar las Categorias por Id
    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity getCategoria(@PathVariable Long id){
        Optional<Categoria> categoria= categoriaRepository.findById(id);
        if (categoria.isPresent()){
            return new ResponseEntity(categoria, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }


    // Moatrar todas las Categorias
    @GetMapping("/categorias")
    public ResponseEntity ListarTodosLasCategorias(){
        List<Categoria> categorias= categoriaRepository.findAll();
        if (categorias.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return  new ResponseEntity(categorias,HttpStatus.OK);
    }


}
