package com.example.ecommerce.controller;


import com.example.ecommerce.domain.categoria.Categoria;
import com.example.ecommerce.domain.categoria.CategoriaCreateResponse;
import com.example.ecommerce.domain.categoria.CategoriaRequestPayload;
import com.example.ecommerce.repositories.CategoriaRepository;
import com.example.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaCreateResponse> criarCategoria(@RequestBody CategoriaRequestPayload payload){
        Categoria categoria = new Categoria(payload);
        categoriaService.criarCategoria(categoria);
        return ResponseEntity.ok(new CategoriaCreateResponse(categoria.getId()));

    }


    @GetMapping("/todasCategorias")
    public ResponseEntity<List<Categoria>> retornaTodasCategorias(){
        List<Categoria> categorias = repository.findAll();
        return ResponseEntity.ok(categorias);
    }
}
