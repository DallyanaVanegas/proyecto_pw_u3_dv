package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;

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

}
