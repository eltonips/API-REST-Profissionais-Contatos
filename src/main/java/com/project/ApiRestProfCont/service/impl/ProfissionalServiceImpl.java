package com.project.ApiRestProfCont.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.ApiRestProfCont.dto.ProfissionalDTO;
import com.project.ApiRestProfCont.entities.Profissional;
import com.project.ApiRestProfCont.repositories.ProfissionalRepository;
import com.project.ApiRestProfCont.service.ProfissionalService;
import com.project.ApiRestProfCont.service.exceptions.DatabaseException;
import com.project.ApiRestProfCont.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public Profissional findById(Long id) {
		Optional<Profissional> obj = profissionalRepository.findById(id);
		return obj.get();
	}
	
	public ProfissionalDTO findByIdDto(Long id) {
		Optional<Profissional> obj = profissionalRepository.findById(id);
		return converteParaDto(obj.get());
	}
	
	public ProfissionalDTO findByParams(String text) {		
		return converteParaDto(profissionalRepository.findByParams(text));
	}
	
	private ProfissionalDTO converteParaDto(Profissional entity) {
		ProfissionalDTO profissionalDTO = new ProfissionalDTO();
		
		profissionalDTO.setId(entity.getId());
		profissionalDTO.setNome(entity.getNome());
		profissionalDTO.setNascimento(entity.getNascimento());
		profissionalDTO.setCreatedDate(entity.getCreatedDate());
		return profissionalDTO;
	}
	
	private Profissional converteParaEntity(ProfissionalDTO dto) {
		Profissional entity = new Profissional();
		entity.setNome(dto.getNome());
		entity.setNascimento(dto.getNascimento());
		entity.setCreatedDate(dto.getCreatedDate());		
		return entity;
	}
	
	public ProfissionalDTO insert(ProfissionalDTO obj) {
		Profissional profissional = this.converteParaEntity(obj);
		profissionalRepository.saveAndFlush(profissional);
		return this.converteParaDto(profissional);
	}
	
	public void delete(Long id) {
		try {
			profissionalRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public Profissional update(Long id, Profissional obj) {
		try {
			Profissional entity = profissionalRepository.getReferenceById(id);
			entity.setNome(obj.getNome());			
			entity.setNascimento(obj.getNascimento());
			return profissionalRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
