package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Hijo;

@Repository
@Transactional
public class HijoRepositoryImpl implements IHijoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hijo> buscarHijosEmpleado(Integer id) {
		TypedQuery<Hijo> myQuery = this.entityManager.createQuery("SELECT e FROM Hijo e WHERE e.empleado.id= :dato", Hijo.class);
		myQuery.setParameter("dato", id);
		return myQuery.getResultList();
	}

}
