package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Favorito;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.FavoritoRepository;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public void addFavorite(Integer usuarioId, Integer filmeId) {
        Usuario usuario = usuarioRepository.findById(usuarioId);
        Filme filme= filmeRepository.findById(filmeId);
        Favorito favorito = new Favorito();
        favorito.setUsuario(usuario);
        favorito.setFilme(filme);
        favoritoRepository.save(favorito);
    }

    public void removeFavorite(Long favoriteId) {
        favoritoRepository.deleteById(favoriteId);
    }

    public List<Favorito> getFavorites(Long userId) {
        Usuario usuario = UsuarioRepository.findById(userId);
        return favoritoRepository.findByUser(usuario);
    }

}
