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

import com.project.ApiRestProfCont.dto.ContatoDTO;
import com.project.ApiRestProfCont.entities.Contato;
import com.project.ApiRestProfCont.service.ContatoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContatoDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(contatoService.findByIdDto(id));
	}
	
	@GetMapping(value = "/{text}")
	public ResponseEntity<ContatoDTO> findByParams(@PathVariable("text") String text, @RequestBody ContatoDTO dto) {
		ContatoDTO contatoDto = contatoService.findByParams(text);
		if(dto.getNome().isEmpty()) contatoDto.setNome(null);
		if(dto.getContato().isEmpty()) contatoDto.setContato(null);
		if(dto.getCreatedDate() == null) contatoDto.setCreatedDate(null);
		if(dto.getProfissionalId() < 0L) contatoDto.setProfissionalId(null);
		return ResponseEntity.ok().body(contatoDto);
	}
	
	@PostMapping
	public ResponseEntity<ContatoDTO> insert(@RequestBody ContatoDTO dto) {
		ContatoDTO contatoRes = contatoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contatoRes.getId()).toUri();
		return ResponseEntity.created(uri).body(contatoRes);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato obj) {
		obj = contatoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
