package com.projetoteste3.project3.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetoteste3.project3.model.Despesa;

@Repository
public interface DespesaRepository extends CrudRepository<Despesa, Long> {
	
}
