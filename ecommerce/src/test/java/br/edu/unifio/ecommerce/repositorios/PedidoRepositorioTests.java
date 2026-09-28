package br.edu.unifio.ecommerce.repositorios;
import br.edu.unifio.ecommerce.entidades.Pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PedidoRepositorioTests {
    @Autowired 
    private PedidoRepositorio pedidoRepositorio;

    @Test 
    public void deveBuscarUmPedidoPorId () {
        Pedido pedido = pedidoRepositorio.findById(Short.parseShort("1")).orElseThrow();

        assertNotNull (pedido);
        assertEquals(LocalDateTime.parse("2026-06-14T14:36:25").plusHours(3), pedido.getData());
        assertEquals("inativo", pedido.getStatus());
    }

    @Test 
    public void deveBuscarTodosPedidos () {
        List<Pedido> pedidos = pedidoRepositorio.findAll();

        assertNotNull (pedidos);
        assertEquals(5, pedidos.size());
    }
}
