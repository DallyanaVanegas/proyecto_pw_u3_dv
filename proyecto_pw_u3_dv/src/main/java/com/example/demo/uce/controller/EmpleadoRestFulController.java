package com.example.demo.uce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestFulController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@PostMapping(consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public String crear(@RequestBody Empleado empleado) {
		String mensaje="Empleado insertado correctamente";
		try {
			this.empleadoService.crear(empleado);
		} catch (Exception e) {
			mensaje="Error intente más tarde";
		}
		return mensaje;
	}
	
	@PutMapping
	public String actualizar(@RequestBody Empleado empleado) {
		String mensaje="Empleado actualizado correctamente";
		try {
			this.empleadoService.actualizar(empleado);
		} catch (Exception e) {
			mensaje="Error intente más tarde";
		}
		return mensaje;	
	}
	
	@GetMapping(path = "/{idEmpleado}",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Empleado> buscar(@PathVariable("idEmpleado") Integer id) {
		Empleado empl = this.empleadoService.buscarPorId(id);
		return ResponseEntity.ok(empl);
	}
	
	@DeleteMapping(path= "/{idEmpleado}")
	public String eliminar(@PathVariable("idEmpleado") Integer id) {
		this.empleadoService.eliminar(id);
		return "Empleado eliminado con exito";
		
	}
	
	@GetMapping
	public List<Empleado> buscarPorSalario(@RequestParam(value = "sal") BigDecimal salario,@RequestParam(value = "provincia") String provincia ) {
		System.out.println(provincia);
		return this.empleadoService.buscarPorSalario(salario);
	}
	
/*
	@GetMapping(path="/adicional")
	public ResponseEntity<List<Empleado>> buscarPorSalario1(@RequestParam(value = "salario") BigDecimal salario) {
		List<Empleado> datos = this.empleadoService.buscarPorSalario(salario);
		return ResponseEntity.ok(datos);
	}*/
	
}
