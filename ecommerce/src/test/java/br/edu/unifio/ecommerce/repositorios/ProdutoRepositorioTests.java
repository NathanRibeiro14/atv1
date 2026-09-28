package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Produto;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ProdutoRepositorioTests {
    @Autowired 
    private ProdutoRepositorio produtoRepositorio;

    @Test 
    public void deveBuscarUmProdutoPorId () {
        Produto produto = produtoRepositorio.findById(Short.parseShort("1")).orElseThrow();

        assertNotNull (produto);
        assertEquals("Código Limpo", produto.getNome());
        assertEquals("Livro do Autor Robert Martin", produto.getDescricao());
    }

    @Test 
    public void deveBuscarTodosProdutos () {
        List<Produto> produtos = produtoRepositorio.findAll();

        assertNotNull (produtos);
        assertEquals(5, produtos.size());
    }
}