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

import br.edu.ifpr.sgta.model.Turma;
import br.edu.ifpr.sgta.repository.TurmaRepository;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaRepository daoTurma;
	
	
	@PostMapping("/save")
	public String form(Turma turma) {
		daoTurma.save(turma);
		return "redirect:/turma/listTurma";
	}
	
	@RequestMapping(value="listTurma", method=RequestMethod.GET)
	public ModelAndView listarTurma() {
		ModelAndView mv= new ModelAndView("turma/listTurma");
		mv.addObject("turmas", daoTurma.findAll());
		mv.addObject("turma", new Turma());
		return mv;
	}
	
//	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newForm(Model model) {
		Turma turma = new Turma();
		model.addAttribute("turma", turma);
		return "turma/insertTurma.html";
	}
	
//	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		daoTurma.removerTurma(id);
		return "redirect:/turma/listTurma";
	}
	
}

	
