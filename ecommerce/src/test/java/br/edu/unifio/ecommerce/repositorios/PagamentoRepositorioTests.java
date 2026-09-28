package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.Pagamento;
import br.edu.unifio.ecommerce.entidades.Pedido;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PagamentoRepositorioTests {
    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;
    @Autowired 
    private ClienteRepositorio clienteRepositorio;
    @Autowired 
    private PedidoRepositorio pedidoRepositorio;

    @Test 
    public void deveBuscarUmPagamentoPorId () {
        Pagamento pagamento = pagamentoRepositorio.findById(Short.parseShort("1")).orElseThrow();

        assertNotNull (pagamento);
        assertThat(new BigDecimal("73.44")).isEqualByComparingTo(pagamento.getValor());
        assertEquals(LocalDateTime.parse("2026-07-29T13:48:44").plusHours(3), pagamento.getData());
    }

    @Test 
    public void deveBuscarTodosPagamentos () {
        List<Pagamento> pagamentos = pagamentoRepositorio.findAll();

        assertNotNull (pagamentos);
        assertEquals(7, pagamentos.size());
    }

    @Test
    public void deveCriarUmPagamento () {
        Cliente cliente = new Cliente();
        cliente.setNome("Mike");
        cliente.setEmail("mikeBaguncinha@gmail.com");
        cliente.setTelefone("43996905193");
        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.parse("2026-08-18T14:32:26"));
        pedido.setStatus("ativo");
        pedido.setValorTotal(new BigDecimal("2000"));
        pedido.setCliente(cliente);
        pedido = pedidoRepositorio.save(pedido);

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(new BigDecimal("2000"));
        pagamento.setData(LocalDateTime.parse("2026-08-18T14:32:26"));
        pagamento.setStatus("pago");
        pagamento.setTipo("Pix");
        pagamento.setPedido(pedido);
        pagamento = pagamentoRepositorio.save(pagamento);

        assertThat(new BigDecimal("2000")).isEqualByComparingTo(pagamento.getValor());
        assertEquals(LocalDateTime.parse("2026-08-18T14:32:26"),pagamento.getData());
        assertEquals("pago", pagamento.getStatus());
        assertEquals("Pix", pagamento.getTipo());
        assertEquals(pedido, pagamento.getPedido());
    }

    @Test 
    public void deveAlterarUmPagamento () {
        Cliente cliente = new Cliente();
        cliente.setNome("Mike");
        cliente.setEmail("mikeBaguncinha@gmail.com");
        cliente.setTelefone("43996905193");
        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.parse("2026-08-18T14:32:26"));
        pedido.setStatus("ativo");
        pedido.setValorTotal(new BigDecimal("2000"));
        pedido.setCliente(cliente);
        pedido = pedidoRepositorio.save(pedido);

        Pedido pedido2 = new Pedido();
        pedido2.setData(LocalDateTime.parse("2026-08-18T14:32:26"));
        pedido2.setStatus("ativo");
        pedido2.setValorTotal(new BigDecimal("2000"));
        pedido2.setCliente(cliente);
        pedido2 = pedidoRepositorio.save(pedido2);

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(new BigDecimal("2000"));
        pagamento.setData(LocalDateTime.parse("2026-08-18T14:32:26"));
        pagamento.setStatus("pago");
        pagamento.setTipo("Pix");
        pagamento.setPedido(pedido);
        pagamento = pagamentoRepositorio.save(pagamento);

        pagamento.setValor(new BigDecimal("3000"));
        pagamento.setData(LocalDateTime.parse("2026-08-19T14:32:26"));
        pagamento.setStatus("pendente");
        pagamento.setTipo("dinheiro");
        pagamento.setPedido(pedido2);

        assertThat(new BigDecimal("3000")).isEqualByComparingTo(pagamento.getValor());
        assertEquals(LocalDateTime.parse("2026-08-19T14:32:26"),pagamento.getData());
        assertEquals("pendente", pagamento.getStatus());
        assertEquals("dinheiro", pagamento.getTipo());
        assertEquals(pedido2, pagamento.getPedido());
    }

    @Test
    public void deveDeletarUmPagamento () {
        Cliente cliente = new Cliente();
        cliente.setNome("Mike");
        cliente.setEmail("mikeBaguncinha@gmail.com");
        cliente.setTelefone("43996905193");
        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.parse("2026-08-18T14:32:26"));
        pedido.setStatus("ativo");
        pedido.setValorTotal(new BigDecimal("2000"));
        pedido.setCliente(cliente);
        pedido = pedidoRepositorio.save(pedido);

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(new BigDecimal("2000"));
        pagamento.setData(LocalDateTime.parse("2026-08-18T14:32:26"));
        pagamento.setStatus("pago");
        pagamento.setTipo("Pix");
        pagamento.setPedido(pedido);
        pagamento = pagamentoRepositorio.save(pagamento);

        pagamentoRepositorio.deleteById(pagamento.getId());
        Optional<Pagamento> pagamentoVerificacao = pagamentoRepositorio.findById(pagamento.getId());
        assertTrue(pagamentoVerificacao.isEmpty());
    }
}
