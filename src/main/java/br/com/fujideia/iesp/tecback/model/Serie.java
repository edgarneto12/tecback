<<<<<<< HEAD
package br.com.fujideia.iesp.tecback.model;
=======
Package br.com.fujideia.sim.tecback.modelo;
>>>>>>> 7afd100a54cfe022a07a4a6f29238dde764b46d4

import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.validator.IdadeRange;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
<<<<<<< HEAD
=======
    private String genero;
>>>>>>> 7afd100a54cfe022a07a4a6f29238dde764b46d4
    private int ano;
    private int duracao;
    private double relevancia;
    private String sinopse;
    private String trailer;

    @IdadeRange(min= 18)
    private Integer classificacaoindicativa;


    private Long anolancado;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;
<<<<<<< HEAD
}

=======
}
>>>>>>> 7afd100a54cfe022a07a4a6f29238dde764b46d4
