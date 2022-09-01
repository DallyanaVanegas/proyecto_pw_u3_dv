package com.example.demo.uce.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class HijoTo extends RepresentationModel<HijoTo> implements Serializable {
	
	private Integer id;
	private String nombre;
	private String genero;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	

}
