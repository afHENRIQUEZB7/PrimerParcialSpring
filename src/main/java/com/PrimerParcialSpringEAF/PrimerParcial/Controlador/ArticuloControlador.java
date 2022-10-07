package com.PrimerParcialSpringEAF.PrimerParcial.Controlador;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.ArticuloRepository;
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


    @GetMapping(value = "/articulo/{id}")
    public ResponseEntity getArticulo(@PathVariable Long id){
        Optional<Articulo> articulo= articuloRepository.findById(id);
        if (articulo.isPresent()){
            return new ResponseEntity(articulo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/articulo/codigo/{codigo}")
    public ResponseEntity getArticulo(@PathVariable String codigo){
        List<Articulo> articulo= articuloRepository.findAllByCodigo(codigo);

        if (articulo.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(articulo,HttpStatus.OK);
    }

    @PostMapping(value = "/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo){
        try {
            articuloRepository.save(articulo);
            return new ResponseEntity(articulo, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    /*@PutMapping("/articulo/codigo/{codigo}")
    public ResponseEntity editarArticulos(@PathVariable String codigo,@RequestBody Articulo articulo){
        Optional<Articulo> articuloBD= articuloRepository.findAllByCodigo(codigo);
        //List<Articulo> articuloBD= articuloRepository.findAllByCodigo(codigo);
        if (articuloBD.isPresent()){
            try{
                articuloBD.get().setCodigo(articulo.getCodigo());
                articuloBD.get().setNombre(articulo.getNombre());
                articuloBD.get().setDescripcion(articulo.getDescripcion());
                articuloBD.get().setStock(articulo.getStock());
                articuloBD.get().setPreciov(articulo.getPreciov());
                articuloBD.get().setPrecioc(articulo.getPrecioc());
                articuloRepository.save(articuloBD.get());
                return new ResponseEntity(articuloBD,HttpStatus.OK);
            }catch (Exception e){
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }*/








}
