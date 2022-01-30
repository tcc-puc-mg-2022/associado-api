package br.com.pucminas.tcc.ms.associadoapi.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "associado", schema = "associado")
public class Associado {

    @Id
    @SequenceGenerator(name = "sq_associado", sequenceName = "sq_associado", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_associado")
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pessoa_fisica", nullable = false, updatable = false)
    private PessoaFisica pessoaFisica;

    @ManyToOne
    @JoinColumn(name = "id_plano", nullable = false)
    private Plano plano;

    @Column(name = "tipo", nullable = false)
    private TipoAssociadoEnum tipo;

    @Column(name = "categoria", nullable = false)
    private CategoriaEnum categoria;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

}
