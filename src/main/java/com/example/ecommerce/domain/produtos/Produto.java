package com.example.ecommerce.domain.produtos;

import com.example.ecommerce.domain.categoria.Categoria;
import com.example.ecommerce.repositories.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID produtoId;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column
    private String imagemUrl;

    @Column(nullable = false)
    private int estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id", nullable = false)
    @JsonIgnore
    private Categoria categoria;


    public Produto(ProdutoRequestPayload data, Categoria categoria){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.preco = data.preco();
        this.imagemUrl = data.imagemUrl();
        this.estoque = data.estoque();
        this.categoria = categoria;
    }


}
