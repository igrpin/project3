package com.projetoteste3.project3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoteste3.project3.Repository.ReceitaRepository;
import com.projetoteste3.project3.ServiceImpl.ReceitaServiceImpl;
import com.projetoteste3.project3.model.Receita;

@Service
public class ReceitaService implements ReceitaServiceImpl {
	
	@Autowired
	private ReceitaRepository rr;
	
	@Override
	public List<Receita> findAll() {
		List<Receita> receita = (List<Receita>) rr.findAll();
		return receita;
	}

	@Override
	public void save(Receita receita) {
		rr.save(receita);
	}

	public Optional<Receita> findById(long id) {
		return rr.findById(id);
	}

	public void delete(Receita receita) {
		rr.delete(receita);
		
	}
}
