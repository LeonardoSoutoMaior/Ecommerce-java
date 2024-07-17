package com.example.ecommerce.controller;

import com.example.ecommerce.domain.produtos.Produto;
import com.example.ecommerce.domain.produtos.ProdutoRequestPayload;
import com.example.ecommerce.repositories.ProdutoRepository;
import com.example.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoRequestPayload payload){
        Produto novoProduto = this.produtoService.criarProduto(payload);
        return ResponseEntity.ok(novoProduto);
    }

    @GetMapping("/todosProdutos")
    public ResponseEntity<List<Produto>> retornaTodosProdutos(){
        List<Produto> produtos = repository.findAll();
        return  ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizaProduto(@PathVariable UUID id, @RequestBody ProdutoRequestPayload payload){
        Optional<Produto> produto = repository.findById(id);

        if (produto.isPresent()){
            Produto novoProduto = produto.get();
            novoProduto.setNome(payload.nome());
            novoProduto.setDescricao(payload.descricao());
            novoProduto.setPreco(payload.preco());
            novoProduto.setImagemUrl(payload.imagemUrl());
            novoProduto.setEstoque(payload.estoque());

            this.repository.save(novoProduto);
            return ResponseEntity.ok(novoProduto);
        }
        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable UUID id){
        Optional<Produto> produto = this.repository.findById(id);

        if (produto.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok("Produto deletado com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}
