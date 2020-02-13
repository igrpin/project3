package com.projetoteste3.project3.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.projetoteste3.project3.model.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Long> {
	
}
