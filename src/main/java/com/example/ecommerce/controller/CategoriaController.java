package com.example.ecommerce.controller;


import com.example.ecommerce.domain.categoria.Categoria;
import com.example.ecommerce.domain.categoria.CategoriaCreateResponse;
import com.example.ecommerce.domain.categoria.CategoriaRequestPayload;
import com.example.ecommerce.repositories.CategoriaRepository;
import com.example.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
