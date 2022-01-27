package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.Encounter;
import com.ty.hospitalwebapp.dto.Orders;

public class OrdersDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	BranchDao branchDao=new BranchDao();
	PersonDao dao=new PersonDao();
	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}
	public boolean addOrder(Orders orders,int encounterId) {
		if(new Encounterdao().getEncounter(1) != null) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	orders.setEncounter(entityManager.find(Encounter.class, encounterId));
		entityManager.persist(orders);
		entityTransaction.commit();
		return true;
		}
		else return false;
	}
	public Orders getOrders(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Orders orders = entityManager.find(Orders.class, id);
		entityTransaction.commit();
		return orders;
	}
	public List<Orders> getOrdersList(int encounterId) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Orders x where x.encounter="+encounterId);
		List<Orders> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}
	public void updateOrders(Orders orders) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(orders);
		entityTransaction.commit();
	}
	public boolean deleteOrders(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Orders orders=entityManager.find(Orders.class, id);
		if(orders != null) {
		entityManager.remove(orders);
		entityTransaction.commit();
		return true;
		}
		entityTransaction.commit();
		return false;
	}

}
