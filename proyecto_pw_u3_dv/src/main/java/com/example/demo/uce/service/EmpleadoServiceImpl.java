package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.to.EmpleadoTo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	public IEmpleadoRepository empleadoRepositorio;
	
	@Override
	public void crear(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepositorio.crear(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepositorio.actualiza(empleado);
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepositorio.buscar(id);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepositorio.eliminar(id);
		
	}

	@Override
	public List<Empleado> buscarPorSalario(BigDecimal salario) {
		
		return this.empleadoRepositorio.buscarPorSalario(salario);
	}

	@Override
	public List<EmpleadoTo> todosLosEmpleados() {
		List<Empleado> lista = this.empleadoRepositorio.todosLosEmpleados();
		List<EmpleadoTo>  listaFinal= lista.stream().map(empleado -> this.convertir(empleado))
		.collect(Collectors.toList());
		return listaFinal;
	}
	
	private EmpleadoTo convertir(Empleado empl) {
		EmpleadoTo emplTo= new EmpleadoTo();
		emplTo.setId(empl.getId());
		emplTo.setNombre(empl.getNombre());
		emplTo.setApellido(empl.getApellido());
		emplTo.setFechaNacimiento(empl.getFechaNacimiento());
		emplTo.setSalario(empl.getSalario());
		return emplTo;
		
	}

}
