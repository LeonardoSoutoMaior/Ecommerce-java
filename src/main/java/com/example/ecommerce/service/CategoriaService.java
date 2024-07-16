package com.example.ecommerce.service;

import com.example.ecommerce.domain.categoria.Categoria;
import com.example.ecommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria){

        if (categoria.getNome() == null){
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio");
        }

        if (categoriaRepository.findByNome(categoria.getNome()).isPresent()){
            throw new IllegalArgumentException("Essa categoria já existe");
        }

        return categoriaRepository.save(categoria);
    }
}
