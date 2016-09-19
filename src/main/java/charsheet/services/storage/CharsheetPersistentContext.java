package charsheet.services.storage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.inject.Produces;

public class CharsheetPersistentContext {
	
	@Charsheet
	@PersistenceContext
	@Produces
	private EntityManager em;

}
