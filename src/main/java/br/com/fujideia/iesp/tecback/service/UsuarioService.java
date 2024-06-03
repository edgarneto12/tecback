package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

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

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
