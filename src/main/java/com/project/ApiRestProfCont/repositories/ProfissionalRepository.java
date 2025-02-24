package com.project.ApiRestProfCont.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.ApiRestProfCont.entities.Profissional;

@Transactional(readOnly = true)
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

	@Query("SELECT profissional "
			+ "FROM Profissional profissional "
			+ "WHERE profissional.nome LIKE '%:text%' ")
	Profissional findByParams(@Param("text") String text);
}
