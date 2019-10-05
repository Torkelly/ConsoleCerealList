package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

public class ListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCerealList");
	
			public void insertNewListDetails(ListDetails ld) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				em.persist(ld);
				em.getTransaction().commit();
				em.close();
			}
			
			public List<ListDetails> getLists() {
				EntityManager em = emfactory.createEntityManager();
				List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
				return allDetails;
			}
			
			public ListDetails searchForListById(Integer tempId) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				ListDetails found = em.find(ListDetails.class, tempId);
				em.close();
				return found;
			}
			
			public void deleteList(ListDetails listToDelete) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<ListDetails> typedQuery = em.createQuery("select d from ListDetails d where d.id = :selectedID", ListDetails.class);
				typedQuery.setParameter("selectedID", listToDelete.getId());
			
				typedQuery.setMaxResults(1);
				
				ListDetails result = typedQuery.getSingleResult();
				em.remove(result);
				em.getTransaction().commit();
				em.close();
			}
			
			public void updateList(ListDetails toEdit) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
					
				em.merge(toEdit);
				em.getTransaction().commit();
				em.close();
			}
}
