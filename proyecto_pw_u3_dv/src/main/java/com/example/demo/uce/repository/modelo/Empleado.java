package com.example.demo.uce.repository.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	
	 private static final long serialVersionUID = 8799656478674716638L;
	@Id
	@Column(name="empl_id")
	private Integer id;
	@Column(name="empl_nombre")
	private String nombre;
	@Column(name="empl_apellido")
	private String apellido;
	@Column(name="empl_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name="empl_salario")
	private BigDecimal salario;
	
	
	//@OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "empleado")
	private List<Hijo> hijos;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Hijo> getHijos() {
		return hijos;
	}

	public void setHijos(List<Hijo> hijos) {
		this.hijos = hijos;
	}

	
	
	
	
	
	
	

}
