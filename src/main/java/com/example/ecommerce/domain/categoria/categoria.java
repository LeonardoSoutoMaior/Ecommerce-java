package com.example.ecommerce.domain.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID categoriaId;

    @Column(name = "nome_categoria", nullable = false)
    private String nome;

    @Column(name = "descricao_categoria", nullable = true)
    private String descricao;
}
