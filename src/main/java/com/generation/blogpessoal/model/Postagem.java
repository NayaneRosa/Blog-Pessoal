package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //Define que será uma tabela
@Table(name = "tb_postagens") //Define o nome da tabela
public class Postagem {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
	private Long id;
	
	//titulo que tenha no minimo 5 caracteres e no maximo 100 caracteres
	@NotBlank(message = "O atributo título é Obrigatório!") //@notblank proibe ausencia de qualquer coisa e resuca espaços em branco
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	@Column(length = 100)
	private String titulo;
	
	//titulo que tenha no minimo 10 caracteres e no maximo 1000 caracteres
	@NotBlank(message = "O atributo texto é Obrigatório!") //@notblank proibe ausencia de qualquer coisa e resuca espaços em branco
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	@Column(length = 1000) //sobrescrevendo quantidade maxima de caracteres padrão
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne //muitas postagens para um tema
	@JsonIgnoreProperties("postagem") //evita recursividade, ignorando a postagem para não entrar em loop
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}