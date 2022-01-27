package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.Adress;
import com.ty.hospitalwebapp.dto.Branch;
import com.ty.hospitalwebapp.dto.Encounter;
import com.ty.hospitalwebapp.dto.Hospital;
import com.ty.hospitalwebapp.dto.Items;
import com.ty.hospitalwebapp.dto.Orders;
import com.ty.hospitalwebapp.dto.Orders;
import com.ty.hospitalwebapp.dto.Person;

public class HospitalDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public void addHospital(Hospital hospital) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}

	// ************************************************************************************************************

	public void deleteHospital(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Hospital hospital = entityManager.find(Hospital.class, id);
		entityManager.remove(hospital);
		entityTransaction.commit();
	}

	public Hospital getHospital(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Hospital hospital = entityManager.find(Hospital.class, id);
		entityTransaction.commit();
		return hospital;
	}

	public List<Hospital> getHospitalList() {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Hospital x");
		List<Hospital> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}

	public void updateHospital(Hospital hospital) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(hospital);
		entityTransaction.commit();
	}

}
