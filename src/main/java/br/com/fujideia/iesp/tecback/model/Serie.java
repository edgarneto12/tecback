package br.com.fujideia.iesp.tecback.model;



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
    private int anoLancado;
    private int duracao;
    private double relevancia;
    private String sinopse;
    private String trailer;

    @IdadeRange(min= 0)
    private Integer classificacaoindicativa;


    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;


}

