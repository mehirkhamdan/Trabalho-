package br.edu.ifpr.sgta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpr.sgta.model.Curso;
import br.edu.ifpr.sgta.repository.CursoRepository;

@RestController
@RequestMapping("/apicurso")
@CrossOrigin() // desabilita CORS policy
public class ApiCursoController {

	 @Autowired
		CursoRepository daoCurso;

		@GetMapping("/permissoes")
		public List<Curso> cursoPerfil(@RequestParam(value = "q", required = false) String query) {
			if (!StringUtils.hasLength(query)) {
				return daoCurso.findAll();
			}
			return daoCurso.findByDescricaoIgnoreCaseContaining(query);
		}

		@GetMapping("/curso/{id}")
		Optional<Curso> getCurso(@PathVariable Long id) {

			Curso curso = daoCurso.findById(id).get();

			return Optional.ofNullable(curso);
		}

		@GetMapping(value = "/cursos")
		Iterable<Curso> getCursos() {
			return daoCurso.findAll();
		}

		@PostMapping("/curso")
		Curso postCurso(@RequestBody Curso curso) {
			daoCurso.save(curso);
			return curso;
		}

		@PutMapping("/curso/{id}")
		ResponseEntity<Curso> putCurso(@PathVariable Long id, @RequestBody Curso curso) {
			Curso r = daoCurso.save(curso);
			if (r != null)
				return new ResponseEntity<>(curso, HttpStatus.CREATED);

			return new ResponseEntity<>(curso, HttpStatus.OK);
		}
}
