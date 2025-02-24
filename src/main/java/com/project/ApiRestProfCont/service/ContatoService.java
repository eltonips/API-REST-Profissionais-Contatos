package com.project.ApiRestProfCont.service;

import com.project.ApiRestProfCont.dto.ContatoDTO;
import com.project.ApiRestProfCont.entities.Contato;

public interface ContatoService {

	Contato findById(Long id);
	
	ContatoDTO findByIdDto(Long id);
	
	ContatoDTO findByParams(String text);
	
	ContatoDTO insert(ContatoDTO obj);
	
	Contato update(Long id, Contato obj);
	
	void delete(Long id);
	
}
