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

import com.projetoteste3.project3.Service.DespesaService;
import com.projetoteste3.project3.model.Despesa;

@RestController
@RequestMapping("/despesa")
public class DespesaController {
	
	@Autowired
	private DespesaService rs;
	
	// Lista todas as despesas pela anotação @Controller
//	@RequestMapping(method = RequestMethod.GET)
//	public String listaDespesas(Model model) {
//		List<Despesa> despesaLista = rs.findAll();
//		model.addAttribute("despesas", despesaLista);
//		return ;
//	}
	
//	@GetMapping(value="/listaDespesas")
//	public ModelAndView listaDespesas(Despesa despesa, Model model) {
//		List<Despesa> despesas = rs.findAll();
//		model.addAttribute("despesas", despesas);
//		return new ModelAndView("despesa"); 
//		
//	}
	
//	@PostMapping(value="/listaDespesas")
//	public ModelAndView cadastrarDespesa(Despesa despesa) {
//		System.out.println(despesa.getValorDespesa());
//		rs.save(despesa);
//		return new ModelAndView("postSucesso"); 
//	}
	
	@GetMapping
	public List<Despesa> listaDespesas() {
		List<Despesa> despesas = rs.findAll();
		return despesas;
		
	}

	@PostMapping
	public ResponseEntity<Despesa> cadastrarDespesa(@RequestBody Despesa despesa) {
		System.out.println(despesa.getValorDespesa());
		try {
			rs.save(despesa);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Despesa> atualizaDespesa(@PathVariable(value = "id") long id, @RequestBody Despesa novaDespesa) {
		Optional<Despesa> velhaDespesa = rs.findById(id);
		if (velhaDespesa.isPresent()) {
			Despesa despesa = velhaDespesa.get();
			despesa.setValorDespesa(novaDespesa.getValorDespesa());
			rs.save(despesa);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Despesa> deletaDespesa(@PathVariable(value="id") long id) {
		Optional<Despesa> despesa = rs.findById(id);
		if (despesa.isPresent()) {
			rs.delete(despesa.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}