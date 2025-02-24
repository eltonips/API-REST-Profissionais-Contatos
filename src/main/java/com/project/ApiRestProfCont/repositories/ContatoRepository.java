package com.project.ApiRestProfCont.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.ApiRestProfCont.entities.Contato;

@Transactional(readOnly = true)
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	@Query("SELECT contato "
			+ "FROM Contato contato "
			+ "WHERE contato.nome LIKE '%:text%' "
			+ "OR contato.contato LIKE '%:text%'")
	Contato findByParams(@Param("text") String text);
}
