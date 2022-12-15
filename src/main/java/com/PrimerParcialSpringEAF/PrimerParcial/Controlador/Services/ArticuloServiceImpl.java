package com.PrimerParcialSpringEAF.PrimerParcial.Controlador.Services;

import com.PrimerParcialSpringEAF.PrimerParcial.utils.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.ArticuloRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArticuloServiceImpl implements ArticuloService{

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Articulo> getArticuloId(long id) {
        Optional<Articulo> articulo= articuloRepository.findById(id);
        if (articulo.isPresent()){
            return new ResponseEntity(articulo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Articulo> getArticulo(String codigo) {
        List<Articulo> articulo= articuloRepository.findAllByCodigo(codigo);

        if (articulo.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(articulo,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Articulo> crearArticulo(Articulo articulo) {
        try {
            articuloRepository.save(articulo);
            return new ResponseEntity(articulo, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Articulo> ListarTodosLosArticulos() {
        List<Articulo> articulos= articuloRepository.findAll();
        if (articulos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return  new ResponseEntity(articulos,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Articulo> editarArticulos(String codigo, Articulo articulo) {
        Optional<Articulo> articuloBD= articuloRepository.findByCodigo(codigo);
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
    }

    @Override
    public ResponseEntity<Articulo> eliminarArticulos(String codigo) {
        Optional<Articulo> articuloBD= articuloRepository.findByCodigo(codigo);
        if (articuloBD.isPresent()) {
            articuloRepository.delete(articuloBD.get());
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
