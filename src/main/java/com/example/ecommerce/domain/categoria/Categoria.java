package com.example.ecommerce.domain.categoria;

import com.example.ecommerce.domain.produtos.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoria_id")
    private UUID id;

    @Column(name = "nome_categoria", nullable = false)
    private String nome;

    @Column(name = "descricao_categoria", length = 500)
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produtos;


}
