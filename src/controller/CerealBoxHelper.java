package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CerealBox;

public class CerealBoxHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleCerealList");
	
	public void insertBox(CerealBox cb) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cb);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings(value = { "unchecked" })
	public List<CerealBox> showAllBoxes() {
		EntityManager em = emfactory.createEntityManager();
		List<CerealBox> allBoxes = em.createQuery("SELECT i FROM CerealBox i").getResultList();
		return allBoxes;
	}
	
	public void	deleteFlavor(CerealBox toDelete)	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CerealBox>typedQuery = em.createQuery("select li from CerealBox li where li.name = :selectedName	and	li.flavor = :selectedFlavor", CerealBox.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedFlavor", toDelete.getFlavor());
		typedQuery.setMaxResults(1);
		CerealBox result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public CerealBox searchForBoxById(int idToEdit)	{
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    CerealBox found = em.find(CerealBox.class, idToEdit);
	    em.close();
	    return found;
	}
	
	public List<CerealBox> searchForBoxByName(String cerealName)	{
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<CerealBox> typedQuery = em.createQuery("select cb from CerealBox cb where cb.name = :selectedName",	CerealBox.class);
	    typedQuery.setParameter("selectedName", cerealName);
	    List<CerealBox>	found =	typedQuery.getResultList();
	    em.close();
	    return found;
	}
	
	public List<CerealBox> searchForBoxByFlavor(String cerealFlavor)	{
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<CerealBox> typedQuery = em.createQuery("select cb from CerealBox cb where cb.flavor = :selectedFlavor", CerealBox.class);
	    typedQuery.setParameter("selectedFlavor", cerealFlavor);
	    List<CerealBox>	found = typedQuery.getResultList();
	    em.close();
	    return found;
	}

	public void updateBox(CerealBox toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);	
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
