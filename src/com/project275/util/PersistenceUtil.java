package com.project275.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

	private static final String PERSISTENCE_UNIT_NAME="PersistenceUnit";
	private static EntityManagerFactory factory;
	private static  EntityManager manager;
	public static EntityManager getEntityManager() {
		factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager=factory.createEntityManager();
		return manager;
		
	}
}
