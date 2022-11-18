package com.PrimerParcialSpringEAF.PrimerParcial.Services;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Categoria;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.CategoriaRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaServiceImpl implements  CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private JWTUtil jwtUtil;


    @Override
    public ResponseEntity<Categoria> crearCategorias(Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return new ResponseEntity(categoria, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Categoria> getCategoria(Long id) {
        Optional<Categoria> categoria= categoriaRepository.findById(id);
        if (categoria.isPresent()){
            return new ResponseEntity(categoria, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Categoria> ListarTodosLasCategorias() {
        List<Categoria> categorias= categoriaRepository.findAll();
        if (categorias.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return  new ResponseEntity(categorias,HttpStatus.OK);
    }
}
