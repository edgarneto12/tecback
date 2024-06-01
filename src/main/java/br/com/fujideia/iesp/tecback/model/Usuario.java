package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomecompleto;
    private String email;
    private String senha;
    private String confirmarsenha;
    private String cpfcnpj;

    private boolean ativacao;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id")
    private Cartao cartao;
}
