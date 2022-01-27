package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.Adress;

public class AdressDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}
	public boolean deleteAdress(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Adress adress = entityManager.find(Adress.class, id);
		if(adress != null) {
		entityManager.remove(adress);
		entityTransaction.commit();
		return true;
		}
		return false;
	}
	public Adress getAdress(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Adress adress = entityManager.find(Adress.class, id);
		entityTransaction.commit();
		return adress;
	}
	public List<Adress> getAdressList(int branchId) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		if(new BranchDao().getBranch(branchId) != null) {
		Query query = entityManager.createQuery("select x from Adress x where branch=1");
		List<Adress> list = query.getResultList();
		entityTransaction.commit();
		return list;
		}
		return null;
	}
	public void updateAdress(Adress adress) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(adress);
		entityTransaction.commit();
	}
	public boolean AddAdress(int branchId,Adress adress) {
		
		if(new BranchDao().getBranch(branchId) != null) {
			entityManager = getEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(adress);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
