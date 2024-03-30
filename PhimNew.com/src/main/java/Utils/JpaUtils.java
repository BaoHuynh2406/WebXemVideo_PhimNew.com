package Utils;

import javax.persistence.*;

public class JpaUtils {
	private static EntityManagerFactory factory;
	
	static public EntityManager getEntityManager() 
	{
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("PhimNew");
		}
		return factory.createEntityManager();
	}
	
	
	static public void shutDown() {
		if(factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}

