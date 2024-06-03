package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.service.SerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/serie")
public class SerieController {

    private final SerieService service;

    @PostMapping
    public Serie salvar(@Valid @RequestBody Serie serie){
        return service.salvar(serie);
    }

    @PutMapping
    public Serie atualizar(@RequestBody Serie serie){
        return service.atualizar(serie);
    }

    @GetMapping
    public List<Serie> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping
    public List<Serie> obterSerieFavorita() {
        return service.getFavorites;
    }
    @GetMapping("/{id}")
    public Serie buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluir(id);
}

    @GetMapping
    public List<Serie> obterSeriesFavoritas() {
        return obterSeriesFavoritas();
    }
}