package com.example.ecommerce.controller;

import com.example.ecommerce.domain.endereco.Endereco;
import com.example.ecommerce.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{usuarioId}")
    public ResponseEntity<Endereco> adicionarEndereco(@PathVariable UUID usuarioId, @RequestBody Endereco endereco){
        Endereco novoEndereco = enderecoService.adicionarEndereco(usuarioId, endereco);
        return ResponseEntity.ok(novoEndereco);
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Endereco> obterEnderecoPorUsuario(@PathVariable UUID usuarioId){
        Endereco endereco = enderecoService.obterEnderecoPorUsuario(usuarioId);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{enderecoId}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable UUID enderecoId, @RequestBody Endereco enderecoAtualizado){
        Endereco endereco = enderecoService.atualizarEndereco(enderecoId, enderecoAtualizado);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/deletar/{enderecoId}")
    public ResponseEntity<String> deletarEndereco(@PathVariable UUID enderecoId){
        enderecoService.deletarEndereco(enderecoId);
        return ResponseEntity.ok("Endereço deletado com sucesso");
    }
}
