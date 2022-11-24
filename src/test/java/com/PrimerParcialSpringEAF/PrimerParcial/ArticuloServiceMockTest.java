package com.PrimerParcialSpringEAF.PrimerParcial;

import com.PrimerParcialSpringEAF.PrimerParcial.Modelo.Articulo;
import com.PrimerParcialSpringEAF.PrimerParcial.Repository.ArticuloRepository;
import com.PrimerParcialSpringEAF.PrimerParcial.Services.ArticuloServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import static com.PrimerParcialSpringEAF.PrimerParcial.CategoriaserviceMockTest.mockCategoria;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
public class ArticuloServiceMockTest {
    public static Articulo mockArticulo() {
        Articulo modelo = new Articulo();
        modelo.setId(1L);
        modelo.setCodigo("123");
        modelo.setNombre("Limpido");
        modelo.setStock("2");
        modelo.setCategoria(mockCategoria());
        modelo.setDescripcion("HCL");
        modelo.setPreciov(2000.0);
        modelo.setPrecioc(5000.0);
        modelo.setFechaarticulo(new Date(10,10,20));

        return modelo;
    }
    public static Articulo mockArticuloMod() {
        Articulo modelo = new Articulo();
        modelo.setId(1L);
        modelo.setCodigo("1");
        modelo.setNombre("Lejia");
        modelo.setStock("2");
        modelo.setCategoria(mockCategoria());
        modelo.setDescripcion("HCL");
        modelo.setPreciov(2000.0);
        modelo.setPrecioc(5000.0);
        modelo.setFechaarticulo(new Date(10,10,20));

        return modelo;
    }
    @InjectMocks
    private ArticuloServiceImpl articuloService;

    @Mock
    private ArticuloRepository articuloRepository;

    @DisplayName("Test para obtener articulos por codigo")
    @Test
    void GetArticleByCodTest() {

        //Given
        Articulo articulo = mockArticulo();

        //When
        when(articuloRepository.findByCodigo(anyString())).thenReturn(Optional.of(articulo));
        ResponseEntity<Articulo> respuesta = articuloService.getArticulo(articulo.getCodigo());

        //Then
        Assertions.assertNotNull(respuesta);

    }

    @DisplayName("Test para listar a los Articulos")
    @Test
    void getAllArticlesTest() {

        //Given
        Articulo articulo = mockArticulo();

        //When

        ResponseEntity<Articulo> lista = articuloService.ListarTodosLosArticulos();

        //Then
        Assertions.assertNotNull(lista);
    }

    @DisplayName("Test para crear Articulo")
    @Test
    void createArticleTest() {
        //Given
        Articulo articulo = mockArticulo();
        given(articuloRepository.findByCodigo(articulo.getCodigo())).willReturn(Optional.of(articulo));
        given(articuloRepository.save(articulo)).willReturn(articulo);
        //When

        ResponseEntity<Articulo> articuloGuardado = articuloService.crearArticulo(articulo);

        //Then
        Assertions.assertNotNull(articuloGuardado);
    }

    @DisplayName("Test para editar un Articulo")
    @Test
    void editArticleTest() {
        // Given
        Articulo articulo = mockArticulo();
        Articulo articuloMod = mockArticuloMod();
        given(articuloRepository.findByCodigo(articulo.getCodigo())).willReturn(Optional.of(articulo));
        given(articuloRepository.save(articuloMod)).willReturn(articuloMod);

        //when

        ResponseEntity<Articulo> articuloGuardado = articuloService.editarArticulos(articulo.getCodigo(), articuloMod);

        //Then
        Assertions.assertNotNull(articuloGuardado);
    }

    @DisplayName("Test para eliminar un Articulo")
    @Test
    void deleteArticleTest() {
        //Given
        Articulo articulo = mockArticulo();


        given(articuloRepository.findByCodigo(articulo.getCodigo())).willReturn(Optional.of(articulo));
        articuloRepository.deleteById(articulo.getId());



        //when

        Optional<Articulo> elmArticulo = articuloRepository.findById(articulo.getId());

        //Then

        assertThat(elmArticulo).isEmpty();


    }

    @Test
    @DisplayName("Test para una lista vacia")
    void listaArticulosVacia() {
        when(articuloRepository.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity mockArticleService = articuloService.ListarTodosLosArticulos();

        Assertions.assertNotNull(mockArticleService);
        Assertions.assertEquals( 404, mockArticleService.getStatusCodeValue());
    }
}

