package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.uce.repository.modelo.Hijo;


public interface IHijoRepository {
	
	public List<Hijo> buscarHijosEmpleado(Integer id);

}
