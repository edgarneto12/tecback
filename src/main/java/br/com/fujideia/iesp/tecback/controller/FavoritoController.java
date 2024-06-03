package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Favorito;
import br.com.fujideia.iesp.tecback.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @PostMapping("/{userId}/movies/{movieId}")
    public ResponseEntity<Void> addFavorite(@PathVariable int userId, @PathVariable int movieId) {
        favoritoService.addFavorite(userId, movieId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long favoriteId) {
        favoritoService.removeFavorite(favoriteId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Favorito>> getFavorites(@PathVariable Long userId) {
        List<Favorito> favorites = favoritoService.getFavorites(userId);
        return ResponseEntity.ok(favorites);
    }
}