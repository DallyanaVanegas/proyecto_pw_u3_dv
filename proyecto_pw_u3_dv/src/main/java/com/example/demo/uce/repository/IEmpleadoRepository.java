package com.example.demo.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.uce.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	
	public void crear(Empleado empleado);
	public void actualiza(Empleado empleado);
	public void eliminar(Integer id);
	public Empleado buscar (Integer id);
	public List<Empleado> buscarPorSalario(BigDecimal salario);
	
}
