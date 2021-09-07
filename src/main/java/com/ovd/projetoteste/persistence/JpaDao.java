package com.ovd.projetoteste.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaDao {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("projetotesteDS");
	private EntityManager em = emFactory.createEntityManager();

	public EntityManager getEntityManager() {
		return em;
	}
}
