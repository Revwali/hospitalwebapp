package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.Encounter;

public class Encounterdao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	BranchDao branchDao = new BranchDao();
	PersonDao dao = new PersonDao();

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public boolean addEncounter(int branchId, int personId, Encounter encounter) {
		if ((branchDao.getBranch(branchId) != null) && (dao.getPerson(personId) != null)) {
			entityManager = getEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			encounter.setBranch(branchDao.getBranch(branchId));
			encounter.setPerson(dao.getPerson(personId));
			entityManager.persist(encounter);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}

	public Encounter getEncounter(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Encounter encounter = entityManager.find(Encounter.class, id);
		entityTransaction.commit();
		return encounter;
	}

	public List<Encounter> getEncounterList(int personId) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Encounter x where x.person="+personId);
		List<Encounter> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}

	public void updateEncounter(Encounter encounter) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(encounter);
		entityTransaction.commit();
	}

	public void deleteEncounter(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Encounter encounter = entityManager.find(Encounter.class, id);
		entityManager.remove(encounter);
		entityTransaction.commit();
	}
}
