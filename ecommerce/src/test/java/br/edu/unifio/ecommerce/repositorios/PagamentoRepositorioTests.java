package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Pagamento;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PagamentoRepositorioTests {
    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;

    @Test 
    public void deveBuscarUmPagamentoPorId () {
        Pagamento pagamento = pagamentoRepositorio.findById(Short.parseShort("1")).orElseThrow();

        assertNotNull (pagamento);
        assertThat(new BigDecimal("73.44")).isEqualByComparingTo(pagamento.getValor());
        assertEquals(LocalDateTime.parse("2026-07-29 13:48:44"), pagamento.getData());
    }

    @Test 
    public void deveBuscarTodosPagamentos () {
        List<Pagamento> pagamentos = pagamentoRepositorio.findAll();

        assertNotNull (pagamentos);
        assertEquals(5, pagamentos.size());
    }
}
