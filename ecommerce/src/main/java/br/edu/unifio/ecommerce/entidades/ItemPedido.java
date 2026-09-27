package br.edu.unifio.ecommerce.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class ItemPedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private short id;
    
    private short quantidade;
    
    private BigDecimal valorUnitario;
    
    @ManyToOne 
    private Pedido pedido;
    
    @ManyToOne 
    private Produto produto;
}
