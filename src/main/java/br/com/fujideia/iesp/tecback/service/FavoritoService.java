package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.handler.FilmeNotFoundException;
import br.com.fujideia.iesp.tecback.handler.UsuarioNotFoundException;
import br.com.fujideia.iesp.tecback.model.Favorito;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.FavoritoRepository;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class FavoritoService {

    private FavoritoRepository favoritoRepository;


    private UsuarioRepository usuarioRepository;


    private FilmeRepository filmeRepository;

    public void addFavorite(Integer usuarioId, Integer filmeId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNotFoundException(usuarioId));
        Filme filme = filmeRepository.findById(filmeId).orElseThrow(() -> new FilmeNotFoundException(filmeId));
        Favorito favorito = new Favorito();
        favorito.setUsuario(usuario);
        favorito.setFilme(filme);
        favoritoRepository.save(favorito);
    }

    public void removeFavorite(Integer favoriteId) {
        favoritoRepository.deleteById(favoriteId);
    }

    public List<Favorito> getFavorites(Integer userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElseThrow(() -> new UsuarioNotFoundException(userId));
        return favoritoRepository.findByUsuario(usuario);
    }

}
