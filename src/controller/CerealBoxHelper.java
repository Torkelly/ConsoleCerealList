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
	
	public List<CerealBox>showAllflavors() {
		EntityManager em = emfactory.createEntityManager();
		List<CerealBox>allBoxes = em.createQuery("SELECT i FROM CerealBox i").getResultList();
		return allBoxes;
	}
	
	public void	deleteflavor(CerealBox toDelete)	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CerealBox>typedQuery = em.createQuery("select li from CerealBox li	where li.name = :selectedname	and	li.flavor	= :selectedflavor",	CerealBox.class);
		typedQuery.setParameter("selectedname", toDelete.getName());
		typedQuery.setParameter("selectedflavor",	toDelete.getFlavor());
		typedQuery.setMaxResults(1);
		CerealBox result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public CerealBox searchForBoxById(int idToEdit)	{
        // TODO	Auto-generated method stub
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    CerealBox found = em.find(CerealBox.class, idToEdit);
	    em.close();
	    return found;
	}
	
	public	List<CerealBox>	searchForflavorByname(String	cerealName)	{
//		TODO	Auto-generated	method	stub
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<CerealBox> typedQuery = em.createQuery("select cb from CerealBox cb where cb.Name = :selectedname",	CerealBox.class);
	    typedQuery.setParameter("Selected Cereal ", cerealName);
	    List<CerealBox>	foundflavors	=	typedQuery.getResultList();
	    em.close();
	    return foundflavors;
	}
	
	public	List<CerealBox>	searchForBoxByflavor(String flavorName)	{
        // TODO	Auto-generated method stub
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<CerealBox> typedQuery = em.createQuery("select cb from CerealBox cb where cb.Name = :selectedflavor", CerealBox.class);
	    typedQuery.setParameter("selectedflavor", flavorName);
	    List<CerealBox>	foundFlavors = typedQuery.getResultList();
	    em.close();
	    return foundFlavors;
	}

	public void updateBox(CerealBox toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
