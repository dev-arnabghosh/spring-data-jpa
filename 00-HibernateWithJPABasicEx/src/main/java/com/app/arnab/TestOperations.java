package com.app.arnab;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityTransaction tx = null;
		try {
			// 1. Load Driver + Create DB Connections + Prepare Statements
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppDB");
			System.out.println(emf.getClass().getName());

			// 2. To do operations like insert/update
			EntityManager em = emf.createEntityManager();
			System.out.println(em.getClass().getName());

			// 3. create Transaction
			tx = em.getTransaction();
			System.out.println(tx.getClass().getName());

			// 4. start transaction
			tx.begin();

			// 5. Perform operation - save data to db
			Employee emp = new Employee();
			emp.setEmpId(10);
			emp.setEmpName("ABC");
			emp.setEmpSal(500.0);

			em.persist(emp); // SQL: INSERT INTO ...

			// 6. commit
			tx.commit();

			// 7. closing resources
			emf.close();

		} catch (Exception e) {
			// TODO: handle exception
			// 8. Rollback if any problem
			tx.rollback();
			e.printStackTrace();
		}
	}

}
