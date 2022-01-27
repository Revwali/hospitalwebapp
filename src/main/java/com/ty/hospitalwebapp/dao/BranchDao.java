package com.ty.hospitalwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalwebapp.dto.Branch;
import com.ty.hospitalwebapp.dto.Hospital;

public class BranchDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	HospitalDao dao = new HospitalDao();

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}

	public boolean addBranch(Branch branch, int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Hospital hospital = dao.getHospital(id);
		if (hospital != null) {
			branch.setHospital(hospital);
			entityManager.persist(branch);
			entityTransaction.commit();
			return true;
		} else {
			entityTransaction.commit();
			return false;
		}
	}

	public List<Branch> getBranchList(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select x from Branch x where x.hospital="+id);
		List<Branch> list = query.getResultList();
		entityTransaction.commit();
		return list;
	}

	public Branch getBranch(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Branch branch = entityManager.find(Branch.class, id);
		entityTransaction.commit();
		return branch;
	}

	public void updateBranch(Branch branch) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
	}
	public void deleteBranch(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Branch branch = entityManager.find(Branch.class, id);
		entityManager.remove(branch);
		entityTransaction.commit();
	}
}
