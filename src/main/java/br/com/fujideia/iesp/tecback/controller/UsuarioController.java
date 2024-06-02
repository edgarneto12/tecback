package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.model.Cartao;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {
    @Autowired
    private UsuarioService Service;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario novoUsuario) {
        return Service.criarUsuario(novoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return Service.atualizarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return Service.listarUsuarios();
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        Service.excluir(id);
    }

    /* @PutMapping("/{id}/cartao")
    public Cartao atualizarCartao(@PathVariable Long id, @RequestBody Cartao cartao) {
        return usuarioService.atualizarCartao(id, cartao);
    } */

}
