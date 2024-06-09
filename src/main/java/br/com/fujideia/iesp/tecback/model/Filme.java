package br.com.fujideia.iesp.tecback.model;

import br.com.fujideia.iesp.tecback.validator.IdadeRange;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private int ano;
    private int duracao;
    private double relevancia;
    private String sinopse;
    private String trailer;

    @IdadeRange(min= 14)
    private Integer classificacaoindicativa;


    private Long anolancado;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;
}
