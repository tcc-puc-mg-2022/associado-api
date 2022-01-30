package br.com.pucminas.tcc.ms.associadoapi.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Entity
@Table(name = "pessoa_fisica", schema = "associado")
public class PessoaFisica {

    @Id
    @SequenceGenerator(name = "sq_pessoa_fisica", sequenceName = "sq_pessoa_fisica", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pessoa_fisica")
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    @CPF(message = "CPF Inválido")
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
}
