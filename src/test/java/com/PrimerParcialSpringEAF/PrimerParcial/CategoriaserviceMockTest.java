package com.PrimerParcialSpringEAF.PrimerParcial;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Categoria;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.CategoriaRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.Services.CategoriaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
@ExtendWith(SpringExtension.class)
public class CategoriaserviceMockTest {
    public static Categoria mockCategoria() {
        Categoria modelo = new Categoria();
        modelo.setId(1L);
        modelo.setNombreca("Ropa");
        modelo.setDescripcionca("Productos de tela");

        return modelo;
    }
    public static Categoria mockCategoriaMod() {
        Categoria modelo = new Categoria();
        modelo.setId(1L);
        modelo.setNombreca("Ropa");
        modelo.setDescripcionca("Productos de algodon");

        return modelo;
    }

    @InjectMocks
    private CategoriaServiceImpl categoriaService;
    @Mock
    private CategoriaRepository categoriaRepository;


    @DisplayName("Test para listar a las categorias")
    @Test
    void gatAllCategoriaTest() {
        //Given
        Categoria categoria = mockCategoria();
        //When
        ResponseEntity<Categoria> lista = categoriaService.ListarTodosLasCategorias();
        //Then
        Assertions.assertNotNull(lista);
    }
    @DisplayName("Test para crear Categoria")
    @Test
    void createArticleTest() {
        //Given
        Categoria categoria = mockCategoria();
        given(categoriaRepository.findById(categoria.getId())).willReturn(Optional.of(categoria));
        given(categoriaRepository.save(categoria)).willReturn(categoria);
        //When

        ResponseEntity<Categoria> categoriaGuardado = categoriaService.crearCategorias(categoria);

        //Then
        Assertions.assertNotNull(categoriaGuardado);
    }

}
