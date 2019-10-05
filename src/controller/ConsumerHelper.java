package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Consumer;

public class ConsumerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCerealList");
	
			public void insertConsumer(Consumer c) {
			    EntityManager em = emfactory.createEntityManager();
			    em.getTransaction().begin();
			    em.persist(c);
			    em.getTransaction().commit();
			    em.close();
			}
			
			public List<Consumer> showAllConsumers() {
				EntityManager em = emfactory.createEntityManager();
				List<Consumer> allConsumers = em.createQuery("SELECT c FROM Consumer c").getResultList();
				return allConsumers;
			}
			
			public Consumer searchForConsumerByName(String shopperName) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<Consumer> typedQuery = em.createQuery("select c from Consumer c where c.consumerName = :selectedName", Consumer.class);
				typedQuery.setParameter("selectedName", shopperName);
				typedQuery.setMaxResults(1);

				Consumer found = typedQuery.getSingleResult();
				em.close();
				return found;
			}
}
