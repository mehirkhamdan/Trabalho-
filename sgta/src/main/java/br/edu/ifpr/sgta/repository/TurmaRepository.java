package br.edu.ifpr.sgta.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpr.sgta.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from Turma t where t.id = :id")
	void removerTurma(Long id);

}
