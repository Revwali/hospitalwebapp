package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.Encounter;
import com.ty.hospitalwebapp.dto.Person;

public class PersonDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public void addPerson(Person person) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void deletePerson(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Person person = entityManager.find(Person.class, id);
		entityManager.remove(person);
		entityTransaction.commit();
	}

	public Person getPerson(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Person person = entityManager.find(Person.class, id);
		entityTransaction.commit();
		return person;
	}

	public List<Person> getPersonList() {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Person x");
		List<Person> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}

	
}
