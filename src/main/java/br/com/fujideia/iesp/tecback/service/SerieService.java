package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SerieService {

//    public List<Serie> getFavorites;
    private SerieRepository repository;

    public Serie salvar(Serie serie){
        return repository.save(serie);
    }

    public List<Serie> listarTodos(){
        return repository.findAll();
    }

    public Serie atualizar(Serie serie){
        if(serie.getId()==null){
            throw new RuntimeException("Serie sem ID");
        }
        return repository.save(serie);
    }

    public Serie buscarPorId(Integer id){
        Optional<Serie> serieOptional = repository.findById(id);
        if (serieOptional.isPresent()) {
            return serieOptional.get();
        } else {
            throw new RuntimeException("Serie não encontrada para o ID: " + id);
        }
    }

    public void excluir(Integer id){
        repository.deleteById(id);
    }


}
