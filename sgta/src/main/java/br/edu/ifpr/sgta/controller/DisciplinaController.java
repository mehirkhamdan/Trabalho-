package br.edu.ifpr.sgta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpr.sgta.model.Disciplina;
import br.edu.ifpr.sgta.repository.DisciplinaRepository;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository daoDisciplina;
	
	
	@PostMapping("/save")
	public String form(Disciplina disciplina) {
		daoDisciplina.save(disciplina);
		return "redirect:/disciplina/listDisciplina";
	}
	
	@RequestMapping(value="listDisciplina", method=RequestMethod.GET)
	public ModelAndView listarDisciplina() {
		ModelAndView mv= new ModelAndView("disciplina/listDisciplina");
		mv.addObject("disciplinas", daoDisciplina.findAll());
		mv.addObject("disciplina", new Disciplina());
		return mv;
	}
	
//	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newForm(Model model) {
		Disciplina disciplina = new Disciplina();
		model.addAttribute("disciplina", disciplina);
		return "disciplina/insertDisciplina.html";
	}
	
//	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		daoDisciplina.removerDisciplina(id);
		return "redirect:/disciplina/listDisciplina";
	}
	
}

