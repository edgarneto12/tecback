package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.model.Cartao;
import br.com.fujideia.iesp.tecback.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService Service;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario novoUsuario) {
        return Service.criarUsuario(novoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return Service.atualizarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return Service.listarUsuarios();
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Integer id) {
        Service.excluir(id);
    }

    /* @PutMapping("/{id}/cartao")
    public Cartao atualizarCartao(@PathVariable Long id, @RequestBody Cartao cartao) {
        return usuarioService.atualizarCartao(id, cartao);
    } */

}
