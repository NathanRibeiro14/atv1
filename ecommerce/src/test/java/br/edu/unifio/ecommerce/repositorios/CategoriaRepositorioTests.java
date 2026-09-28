package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositorioTests {
    @Autowired 
    private CategoriaRepositorio categoriaRepositorio;

    @Test 
    public void deveBuscarUmaCategoriaPorId () {
        Categoria categoria = categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();

        assertNotNull (categoria);
        assertEquals("Eletrônicos", categoria.getNome());
        assertEquals("Equipamentos Eletrônicos", categoria.getDescricao());
    }

    @Test 
    public void deveBuscarTodasCategorias () {
        List<Categoria> categorias = categoriaRepositorio.findAll();

        assertNotNull (categorias);
        assertEquals(5, categorias.size());
    }

    @Test 
    public void deveCriarUmaCategoria () {
        Categoria categoria = new Categoria();
        categoria.setNome("Livros");
        categoria.setDescricao("Livros Técnicos");
        categoria = categoriaRepositorio.save(categoria);

        assertEquals("Livros", categoria.getNome());
        assertEquals("Livros Técnicos", categoria.getDescricao());
    }

    @Test 
    public void deveAlterarUmaCategoria () {
        Categoria categoria = new Categoria();
        categoria.setNome("Livros");
        categoria.setDescricao("Livros Técnicos");
        categoria = categoriaRepositorio.save(categoria);

        categoria.setNome("Dicionarios");
        categoria.setDescricao("Livros diversos");

        assertEquals("Dicionarios", categoria.getNome());
        assertEquals("Livros diversos", categoria.getDescricao());
    }

    @Test 
    public void deveDeletarUmaCategoria () {
        Categoria categoria = new Categoria();
        categoria.setNome("Livros");
        categoria.setDescricao("Livros Técnicos");
        categoria = categoriaRepositorio.save(categoria);

        categoriaRepositorio.deleteById(categoria.getId());
        Optional<Categoria> categoriaVerificacao = categoriaRepositorio.findById(categoria.getId());
        assertTrue(categoriaVerificacao.isEmpty());
    }
}
