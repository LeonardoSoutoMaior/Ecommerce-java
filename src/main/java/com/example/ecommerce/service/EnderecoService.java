package com.example.ecommerce.service;

import com.example.ecommerce.domain.endereco.Endereco;
import com.example.ecommerce.domain.usuarios.Usuario;
import com.example.ecommerce.repositories.EnderecoRepository;
import com.example.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Endereco adicionarEndereco(UUID usuarioId, Endereco endereco){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            endereco.setUsuario(usuario);
            return enderecoRepository.save(endereco);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Endereco obterEnderecoPorUsuario(UUID usuarioId){
        return enderecoRepository.findByUsuarioId(usuarioId);
    }

    public Endereco atualizarEndereco(UUID enderecoId, Endereco enderecoAtualizado){
        Optional<Endereco> enderecoOpt = enderecoRepository.findById(enderecoId);
        if (enderecoOpt.isPresent()){
            Endereco endereco = enderecoOpt.get();
            endereco.setRua(enderecoAtualizado.getRua());
            endereco.setCidade(enderecoAtualizado.getCidade());
            endereco.setEstado(enderecoAtualizado.getEstado());
            endereco.setCep(enderecoAtualizado.getCep());
            return enderecoRepository.save(endereco);
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }

    public void deletarEndereco(UUID enderecoId){
        enderecoRepository.deleteById(enderecoId);
    }
}
