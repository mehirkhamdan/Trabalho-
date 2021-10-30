package br.edu.ifpr.sgta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpr.sgta.model.Curso;
import br.edu.ifpr.sgta.repository.CursoRepository;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository daoCurso;
	
	
	@PostMapping("/save")
	public String form(Curso curso) {
		daoCurso.save(curso);
		return "redirect:/curso/listCurso";
	}
	
	@RequestMapping(value="listCurso", method=RequestMethod.GET)
	public ModelAndView listarCurso() {
		ModelAndView mv= new ModelAndView("curso/listCurso");
		mv.addObject("cursos", daoCurso.findAll());
		mv.addObject("curso", new Curso());
		return mv;
	}
	
//	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newForm(Model model) {
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		return "curso/insertCurso.html";
	}
	
//	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		daoCurso.removerCurso(id);
		return "redirect:/curso/listCurso";
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<Curso> cursos = daoCurso.findAll();
		model.addAttribute("curs", cursos);
		return "curso/listCurso.html";
	}
	
}
