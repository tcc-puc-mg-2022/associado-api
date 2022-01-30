package br.com.pucminas.tcc.ms.associadoapi.repository;

import br.com.pucminas.tcc.ms.associadoapi.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    @Query("select case when count (a) > 0 then true else false end from Associado a where a.pessoaFisica.cpf = :cpf")
    boolean existsByCpf(String cpf);

}
