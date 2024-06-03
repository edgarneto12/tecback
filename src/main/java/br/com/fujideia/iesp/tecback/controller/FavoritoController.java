package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Favorito;
import br.com.fujideia.iesp.tecback.service.FavoritoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/favorites")
public class FavoritoController {


    private FavoritoService favoritoService;

    @PostMapping("/{userId}/movies/{movieId}")
    public ResponseEntity<Void> addFavorite(@PathVariable Integer userId, @PathVariable Integer movieId) {
        favoritoService.addFavorite(userId, movieId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Integer favoriteId) {
        favoritoService.removeFavorite(favoriteId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Favorito>> getFavorites(@PathVariable Integer userId) {
        List<Favorito> favorites = favoritoService.getFavorites(userId);
        return ResponseEntity.ok(favorites);
    }
}