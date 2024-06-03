package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Favorito;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.FavoritoRepository;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FavoritoService {

    private FavoritoRepository favoritoRepository;


    private UsuarioRepository usuarioRepository;


    private FilmeRepository filmeRepository;

    public void addFavorite(Integer usuarioId, Integer filmeId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        Filme filme = filmeRepository.findById(filmeId).orElseThrow();
        Favorito favorito = new Favorito();
        favorito.setUsuario(usuario);
        favorito.setFilme(filme);
        favoritoRepository.save(favorito);
    }

    public void removeFavorite(Integer favoriteId) {
        favoritoRepository.deleteById(favoriteId);
    }

    public List<Favorito> getFavorites(Integer userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElseThrow();
        return favoritoRepository.findByUser(usuario);
    }

}
