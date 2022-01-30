package br.com.pucminas.tcc.ms.associadoapi.repository;

import br.com.pucminas.tcc.ms.associadoapi.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
}
