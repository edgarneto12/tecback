package br.com.fujideia.iesp.tecback.repository;

import java.util.List;
import br.com.fujideia.iesp.tecback.model.Favorito;
import br.com.fujideia.iesp.tecback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {

    List<Favorito> findByUsuario(Usuario usuario);
}
