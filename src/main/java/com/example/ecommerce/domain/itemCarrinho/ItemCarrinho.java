package com.example.ecommerce.domain.itemCarrinho;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.produtos.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    public ItemCarrinho(Produto produto, Carrinho carrinho, int quantidade){
        this.produto = produto;
        this.carrinho = carrinho;
        this.quantidade = quantidade;
    }
}
