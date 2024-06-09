package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.handler.HandlerNotFoundException;
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
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new HandlerNotFoundException("Usuario com o id: " + usuarioId +"não foi encontrado"));
        Filme filme = filmeRepository.findById(filmeId).orElseThrow(() -> new HandlerNotFoundException("Filme com o Id:" + filmeId + "não foi encontrado"));
        Favorito favorito = new Favorito();
        favorito.setUsuario(usuario);
        favorito.setFilme(filme);
        favoritoRepository.save(favorito);
    }

    public void removeFavorite(Integer favoriteId) {
        favoritoRepository.deleteById(favoriteId);
    }

    public List<Favorito> getFavorites(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new HandlerNotFoundException("Usuario com o id: " + usuarioId +"não foi encontrado"));
        return favoritoRepository.findByUsuario(usuario);
    }

}
