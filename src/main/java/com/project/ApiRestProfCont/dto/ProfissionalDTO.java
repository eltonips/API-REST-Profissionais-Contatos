package com.project.ApiRestProfCont.dto;

import java.sql.Date;
import java.util.List;

import com.project.ApiRestProfCont.entities.Contato;

public class ProfissionalDTO {

	private Long id;
	private String nome;
	private Date nascimento;
	private Date createdDate;
	private List<Contato> contatos;
	
	public ProfissionalDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
}
