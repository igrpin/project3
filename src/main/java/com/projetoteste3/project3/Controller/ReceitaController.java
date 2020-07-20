package com.projetoteste3.project3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoteste3.project3.Service.ReceitaService;
import com.projetoteste3.project3.model.Receita;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService rs;
	
	// Lista todas as receitas pela anotação @Controller
//	@RequestMapping(method = RequestMethod.GET)
//	public String listaReceitas(Model model) {
//		List<Receita> receitaLista = rs.findAll();
//		model.addAttribute("receitas", receitaLista);
//		return ;
//	}
	
//	@GetMapping(value="/listaReceitas")
//	public ModelAndView listaReceitas(Receita receita, Model model) {
//		List<Receita> receitas = rs.findAll();
//		model.addAttribute("receitas", receitas);
//		return new ModelAndView("receita"); 
//		
//	}
	
//	@PostMapping(value="/listaReceitas")
//	public ModelAndView cadastrarReceita(Receita receita) {
//		System.out.println(receita.getValorReceita());
//		rs.save(receita);
//		return new ModelAndView("postSucesso"); 
//	}
	
	@GetMapping
	public List<Receita> listaReceitas() {
		List<Receita> receitas = rs.findAll();
		return receitas;
		
	}

	@PostMapping
	public ResponseEntity<Receita> cadastrarReceita(@RequestBody Receita receita) {
		System.out.println(receita.getValorReceita());
		try {
			rs.save(receita);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Receita> atualizaReceita(@PathVariable(value = "id") long id, @RequestBody Receita novaReceita) {
		Optional<Receita> velhaReceita = rs.findById(id);
		if (velhaReceita.isPresent()) {
			Receita receita = velhaReceita.get();
			receita.setValorReceita(novaReceita.getValorReceita());
			rs.save(receita);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Receita> deletaReceita(@PathVariable(value="id") long id) {
		Optional<Receita> receita = rs.findById(id);
		if (receita.isPresent()) {
			rs.delete(receita.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}