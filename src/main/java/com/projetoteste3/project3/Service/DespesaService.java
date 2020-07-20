package com.projetoteste3.project3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoteste3.project3.Repository.DespesaRepository;
import com.projetoteste3.project3.ServiceImpl.DespesaServiceImpl;
import com.projetoteste3.project3.model.Despesa;

@Service
public class DespesaService implements DespesaServiceImpl {
	
	@Autowired
	private DespesaRepository dr;
	
	@Override
	public List<Despesa> findAll() {
		List<Despesa> despesa = (List<Despesa>) dr.findAll();
		return despesa;
	}

	@Override
	public void save(Despesa despesa) {
		dr.save(despesa);
	}

	public Optional<Despesa> findById(long id) {
		return dr.findById(id);
	}

	public void delete(Despesa despesa) {
		dr.delete(despesa);
		
	}
}
