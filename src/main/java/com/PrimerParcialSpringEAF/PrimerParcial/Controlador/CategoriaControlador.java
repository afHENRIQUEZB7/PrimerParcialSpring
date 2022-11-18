package com.PrimerParcialSpringEAF.PrimerParcial.Controlador;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Categoria;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.CategoriaRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.Services.CategoriaService;
import com.PrimerParcialSpringEAF.PrimerParcial.utils.JWTUtil;
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

    @Autowired
    private JWTUtil jwtUtil;


    // Agregar Categorias nuevos
    @PostMapping(value = "/categoria")
    public ResponseEntity crearCategorias(@RequestBody Categoria categoria, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return categoriaService.crearCategorias(categoria);

    }

    // Mostrar las Categorias por Id
    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity getCategoria(@PathVariable Long id, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return categoriaService.getCategoria(id);
    }


    // Moatrar todas las Categorias
    @GetMapping("/categorias")
    public ResponseEntity ListarTodosLasCategorias( @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return categoriaService.ListarTodosLasCategorias();
    }


}
