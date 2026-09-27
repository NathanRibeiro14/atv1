package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.ItemPedido;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ItemPedidoRepositorioTests {
    @Autowired 
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Test 
    public void deveBuscarUmItemPedidoPorId () {
        ItemPedido itemPedido = itemPedidoRepositorio.findById(Short.parseShort("1")).orElseThrow();

        assertNotNull (itemPedido);
        assertEquals(Short.parseShort("1"), itemPedido.getQuantidade());
        assertEquals(new BigDecimal("73.44"), itemPedido.getValorUnitario());
    }

    @Test 
    public void deveBuscarTodosItensPedidos () {
        List<ItemPedido> itemPedidos = itemPedidoRepositorio.findAll();

        assertNotNull (itemPedidos);
        assertEquals(5, itemPedidos.size());
    } 
}
