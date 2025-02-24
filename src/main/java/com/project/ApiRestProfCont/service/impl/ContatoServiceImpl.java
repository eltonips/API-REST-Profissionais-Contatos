package com.project.ApiRestProfCont.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.ApiRestProfCont.dto.ContatoDTO;
import com.project.ApiRestProfCont.entities.Contato;
import com.project.ApiRestProfCont.repositories.ContatoRepository;
import com.project.ApiRestProfCont.service.ContatoService;
import com.project.ApiRestProfCont.service.ProfissionalService;
import com.project.ApiRestProfCont.service.exceptions.DatabaseException;
import com.project.ApiRestProfCont.service.exceptions.ResourceNotFoundException;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoServiceImpl implements ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Resource
	private ProfissionalService profissionalService;
	
	public Contato findById(Long id) {
		Optional<Contato> obj = contatoRepository.findById(id);
		return obj.get();
	}
	
	public ContatoDTO findByIdDto(Long id) {
		Optional<Contato> obj = contatoRepository.findById(id);
		return converteParaDto(obj.get());
	}
	
	private ContatoDTO converteParaDto(Contato entity) {
		ContatoDTO contatoDto = new ContatoDTO();
		
		contatoDto.setId(entity.getId());
		contatoDto.setNome(entity.getNome());
		contatoDto.setProfissionalId(entity.getProfissionalId().getId());
		return contatoDto;
	}
	
	private Contato converteParaEntity(ContatoDTO dto) {
		Contato entity = new Contato();
		entity.setNome(dto.getNome());
		entity.setContato(dto.getContato());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setProfissionalId(profissionalService.findById(dto.getProfissionalId()));
		return entity;
	}
	
	public ContatoDTO insert(ContatoDTO obj) {
		Contato contato = this.converteParaEntity(obj);
		contatoRepository.saveAndFlush(contato);
		return this.converteParaDto(contato);
	}
	
	public ContatoDTO findByParams(String text) {		
		return converteParaDto(contatoRepository.findByParams(text));
	}
	
	public void delete(Long id) {
		try {
			contatoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public Contato update(Long id, Contato obj) {
		try {
			Contato entity = contatoRepository.getReferenceById(id);
			entity.setNome(obj.getNome());
			entity.setContato(obj.getContato());
			entity.setProfissionalId(obj.getProfissionalId());
			return contatoRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
