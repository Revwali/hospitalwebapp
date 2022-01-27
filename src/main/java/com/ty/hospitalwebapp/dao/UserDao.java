package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	//HospitalDao dao = new HospitalDao();

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public void addUser(User user) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public User getUser(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		return entityManager.find(User.class, id);
	}

	public List<User> getAllUsers() {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select u from User u");
		List<User> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}

	public User validateUser(String mail, String password) {
	
		for (User user : getAllUsers()) {
			if (user.getMail().equals(mail) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
