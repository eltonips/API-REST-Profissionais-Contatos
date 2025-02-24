package com.project.ApiRestProfCont.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.ApiRestProfCont.dto.ProfissionalDTO;
import com.project.ApiRestProfCont.entities.Profissional;
import com.project.ApiRestProfCont.service.ProfissionalService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfissionalDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(profissionalService.findByIdDto(id));
	}
	
	@GetMapping(value = "/{text}")
	public ResponseEntity<ProfissionalDTO> findByParams(@PathVariable("text") String text, @RequestBody ProfissionalDTO dto) {
		ProfissionalDTO profissionalDto = profissionalService.findByParams(text);
		if(dto.getNome().isEmpty()) profissionalDto.setNome(null);
		if(dto.getNascimento() == null) profissionalDto.setNascimento(null);				
		return ResponseEntity.ok().body(profissionalDto);
	}
	
	@PostMapping
	public ResponseEntity<ProfissionalDTO> insert(@RequestBody ProfissionalDTO dto) {
		ProfissionalDTO profissionalRes = profissionalService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profissionalRes.getId()).toUri();
		return ResponseEntity.created(uri).body(profissionalRes);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Profissional> update(@PathVariable Long id, @RequestBody Profissional obj) {
		obj = profissionalService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
