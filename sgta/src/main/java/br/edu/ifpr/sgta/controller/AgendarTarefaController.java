package br.edu.ifpr.sgta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpr.sgta.model.AgendarTarefa;
import br.edu.ifpr.sgta.repository.AgendarTarefaRepository;

@Controller
@RequestMapping("agendarTarefa")
public class AgendarTarefaController {
	
	@Autowired
	private AgendarTarefaRepository agendarTarefas;
	
	////Mapeamento da pagina insertAgendarTarefa
	@GetMapping("/insertAgendarTarefa")
	public String form() {
		return "agendarTarefa/insertAgendarTarefa";
	}
	
	//POST do formulario insertAgendarTarefa
	@PostMapping("/insertAgendarTarefa")
	public String form(AgendarTarefa agendarTarefa) {
		agendarTarefas.save(agendarTarefa);
		return "redirect:/insertAgendarTarefa";
	}
	
	//Mapeamento da pagina listAgendarTarefa
	@GetMapping("/listAgendarTarefa")
	public ModelAndView listarAgendarTarefa() {
		ModelAndView mv = new ModelAndView("agendarTarefa/listAgendarTarefa");
		mv.addObject("agendarTarefaes", agendarTarefas.findAll());
		mv.addObject("agendarTarefa", new AgendarTarefa());
		return mv;
	}
}
