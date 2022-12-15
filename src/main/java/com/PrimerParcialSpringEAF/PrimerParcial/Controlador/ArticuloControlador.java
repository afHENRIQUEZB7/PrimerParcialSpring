package com.PrimerParcialSpringEAF.PrimerParcial.Controlador;

import com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.ArticuloRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.Controlador.Services.ArticuloService;
import com.PrimerParcialSpringEAF.PrimerParcial.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class ArticuloControlador {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping(value = "/articulo/{id}")
    public ResponseEntity getArticulo(@PathVariable Long id, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return articuloService.getArticuloId(id);
    }

    // Mostrar los articulos por el Codigo
    @GetMapping(value = "/articulo/codigo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return articuloService.getArticulo(codigo);
    }


    // Agregar Articulos nuevos
    @PostMapping(value = "/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return articuloService.crearArticulo(articulo);
    }

    // Visualizar todos los articulos
    @GetMapping("/articulos")
    public ResponseEntity ListarTodosLosArticulos( @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return articuloService.ListarTodosLosArticulos();
    }



    //Modificación del articulo por el codigo
    @PutMapping("/articulo/codigo/{codigo}")
    public ResponseEntity editarArticulos(@PathVariable String codigo,@RequestBody Articulo articulo, @RequestHeader(value = "Authorization") String token){
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
       return articuloService.editarArticulos(codigo,articulo);
    }


    //Eliminar Articulos
    @DeleteMapping("/articulo/codigo/{codigo}")
    public ResponseEntity eliminarArticulos(@PathVariable String codigo, @RequestHeader(value = "Authorization") String token) {
        if (jwtUtil.getKey(token)== null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no valido");
        }
        return articuloService.eliminarArticulos(codigo);
    }








}



