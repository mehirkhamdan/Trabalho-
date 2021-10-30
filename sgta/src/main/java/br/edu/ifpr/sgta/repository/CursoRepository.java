package br.edu.ifpr.sgta.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.sgta.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from Curso c where c.id = :id")
	void removerCurso(Long id);

	List<Curso> findByDescricaoIgnoreCaseContaining(String descricao);
	
}
