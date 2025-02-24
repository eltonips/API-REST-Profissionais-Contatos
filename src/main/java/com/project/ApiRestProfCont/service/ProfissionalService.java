package com.project.ApiRestProfCont.service;

import com.project.ApiRestProfCont.dto.ProfissionalDTO;
import com.project.ApiRestProfCont.entities.Profissional;

public interface ProfissionalService {

	Profissional findById(Long id);
	
	ProfissionalDTO findByIdDto(Long id);
	
	ProfissionalDTO findByParams(String text);
	
	ProfissionalDTO insert(ProfissionalDTO obj);
	
	Profissional update(Long id, Profissional obj);
	
	void delete(Long id);
}
