package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.model.Cartao;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import br.com.fujideia.iesp.tecback.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario novoUsuario) {
        if (usuarioRepository.findByEmail(novoUsuario.getEmail()) == null){
            return usuarioRepository.save(novoUsuario);
        }else {
            throw new RuntimeException("Esse Email já existe no sistema.");
        }
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        if (usuario.getId()==null){
            throw new RuntimeException("Usuario sem ID");
        }else {
            return usuarioRepository.save(usuario);
        }
    }

    public void excluir(Long id) {usuarioRepository.deleteById(id);
    }

    /* public Cartao atualizarCartao(Long usuarioId, Cartao novoCartao) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        Cartao cartaoAtual = usuario.getCartao();
        cartaoAtual.setNumero(novoCartao.getNumero());
        cartaoAtual.setCodigoSeguranca(novoCartao.getCodigoSeguranca());
        cartaoAtual.setNomeTitular(novoCartao.getNomeTitular());
        cartaoAtual.setDataValidadeMMYY(novoCartao.getDataValidadeMMYY());
        return cartaoRepository.save(cartaoAtual);
    } */

}
