package com.example.demo.uce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.uce.repository.modelo.Estudiante;
import com.example.demo.uce.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteRestFulController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@PostMapping
	public String crear(@RequestBody Estudiante estudiante) {
		String mensaje="Estudiante insertado correctamente";
		try {
			this.estudianteService.crear(estudiante);
		} catch (Exception e) {
			mensaje="Error intente más tarde";
		}
		return mensaje;
	}
	
	@PutMapping
	public String actualizar(@RequestBody Estudiante estudiante) {
		String mensaje="Estudiante actualizado correctamente";
		try {
			this.estudianteService.actualizar(estudiante);
		} catch (Exception e) {
			mensaje="Error intente más tarde";
		}
		return mensaje;	
	}
	
	@GetMapping(path = "/{idEstudiante}")
	public ResponseEntity<Estudiante> buscar(@PathVariable("idEstudiante") Integer id) {
		Estudiante empl = this.estudianteService.buscarPorId(id);
		return ResponseEntity.ok(empl);
	}
	
	@DeleteMapping(path= "/{idEstudiante}")
	public String eliminar(@PathVariable("idEstudiante") Integer id) {
		this.estudianteService.eliminar(id);
		return "Estudiante eliminado con exito";	
	}
	
	@GetMapping
	public List<Estudiante> buscarPorSemestre(@RequestParam (value="se") Integer semestre ){
		return this.estudianteService.buscarPorSemestre(semestre);
		
	}

	

}
