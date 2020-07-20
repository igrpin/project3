package com.projetoteste3.project3.ServiceImpl;

import java.util.List;

import com.projetoteste3.project3.model.Despesa;

public interface DespesaServiceImpl {
	
	List<Despesa> findAll();
	void save(Despesa despesa);
}
