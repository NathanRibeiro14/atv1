package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Cliente;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ClienteRepositorioTests {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test 
    public void deveBuscarUmClientePorId () {
        Cliente cliente = clienteRepositorio.findById(Short.parseShort("1")).orElseThrow();

        assertNotNull (cliente);
        assertEquals("Mike", cliente.getNome());
        assertEquals("mikeBaguncinha@hotmail.com", cliente.getEmail());
    }

    @Test 
    public void deveBuscarTodosClientes () {
        List<Cliente> clientes = clienteRepositorio.findAll();

        assertNotNull (clientes);
        assertEquals(5, clientes.size());
    } 
}
