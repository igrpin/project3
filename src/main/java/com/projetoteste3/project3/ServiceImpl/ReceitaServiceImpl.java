package com.projetoteste3.project3.ServiceImpl;

import java.util.List;

import com.projetoteste3.project3.model.Receita;

public interface ReceitaServiceImpl {
	
	List<Receita> findAll();
	void save(Receita receita);
}
