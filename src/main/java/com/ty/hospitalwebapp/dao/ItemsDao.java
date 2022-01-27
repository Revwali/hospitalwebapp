package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.Items;

public class ItemsDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}
	public void updateItem(Items item) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}
	public List<Items> getItemList(int orderid) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Items x where x.orders="+orderid);
		List<Items> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}  
	public boolean addItem(Items item,int ordersId) {
		if(new OrdersDao().getOrders(ordersId) != null) {
			item.setOrders(new OrdersDao().getOrders(ordersId));
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
		return true;
		}
		return false;
	}
	public Items getItem(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Items item = entityManager.find(Items.class, id);
		entityTransaction.commit();
		return item;
	}
	public boolean deleteItem(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	   Items items=entityManager.find(Items.class, id);
	   if(items != null) {
		   entityManager.remove(items);
		   entityTransaction.commit();
		   return true;
	   }
	   else
	   {
		   entityTransaction.commit();
		   return false;
	   }
	}
}
