package com.example.ecommerce.controller;

import com.example.ecommerce.domain.carrinho.Carrinho;
import com.example.ecommerce.domain.usuarios.AutenticacaoDTO;
import com.example.ecommerce.domain.usuarios.LoginResponseDTO;
import com.example.ecommerce.domain.usuarios.RegistroDTO;
import com.example.ecommerce.domain.usuarios.Usuario;
import com.example.ecommerce.infra.security.TokenService;
import com.example.ecommerce.repositories.CarrinhoRepository;
import com.example.ecommerce.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autenticar")
public class AuthenticationController {

    @Autowired
    private  TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistroDTO data){
        if (this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novoUsuario = new Usuario(data.nome(), data.sobrenome(), data.email(), encryptedPassword, data.role());

        Usuario usuarioSalvo = this.repository.save(novoUsuario);

        Carrinho novoCarrinho = new Carrinho();
        novoCarrinho.setUsuario(usuarioSalvo);
        this.carrinhoRepository.save(novoCarrinho);

        return ResponseEntity.ok().build();
    }
}
