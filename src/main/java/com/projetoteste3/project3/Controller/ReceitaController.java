package com.projetoteste3.project3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoteste3.project3.Service.ReceitaService;
import com.projetoteste3.project3.model.Receita;

@Controller
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
	
	@GetMapping
	public String listaReceitas(Model model) {
		List<Receita> receitas = rs.findAll();
		model.addAttribute("receitas", receitas);
		return "receita";
		
	}
	
	
	@PostMapping
	public void cadastrarReceita(Receita receita) {
		rs.save(receita);
	}
}