package com.example.demo.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.uce.service.IHijoService;
import com.example.demo.uce.service.to.HijoTo;

public class HijoResFulController {
	
	@Autowired
	private IHijoService hijoService;
	
	@GetMapping(path = "/{idEmpleado}/hijos")
	public List<HijoTo> buscarHijos(@PathVariable("idEmpleado") Integer idEmpleado){
		return this.hijoService.buscarHijosEmpleados(idEmpleado);
	}

}
