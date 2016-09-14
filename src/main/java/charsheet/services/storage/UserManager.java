package charsheet.services.storage;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import charsheet.entities.User;
import charsheet.services.logging.LogUserPersistence;

@Singleton
@Startup
public class UserManager {
	
	@PersistenceContext
	EntityManager em;
	
	@LogUserPersistence
	public void addUser(User u){
		em.persist(u);
		
		// TODO: fix UserPersistenceLogger interceptor and remove below
		System.out.println("Adding: " + u);			 
	}
	
	@LogUserPersistence
	public void modifyUser(User u){
		em.merge(u);
	}
	
	@LogUserPersistence
	public void deleteUser(User u){
		em.remove(u);
		
		// TODO: fix UserPersistenceLogger interceptor and remove below
		System.out.println("Deleting: " + u);
	}
	
	public void deleteUser(String name) {
		User u = getUser(name);
		deleteUser(u);
	}
	
	public User getUser(String name){
		
		return em.find(User.class, name);
	}
	
	public List<User> getAllUsers(){
		
		CriteriaQuery<User> criteria = em.getCriteriaBuilder()
				.createQuery(User.class);
		
		return em.createQuery(
				criteria.select(criteria.from(User.class)))
				.getResultList();
	}
	
	@PostConstruct
	private void initialUsers() {
		
		User player1 = new User();
		player1.setUsername("Timmy");
		player1.setPassword("ShivanDragon");
		player1.setRole("player");
		
		User dm = new User();
		dm.setUsername("ComicBookGuy");
		dm.setPassword("WorstEver");
		dm.setRole("dungeonmaster");
		
		addUser(player1);
		addUser(dm);
	}
	
	@PreDestroy
	private void teardownUsers(){
		List<User> users = getAllUsers();
		
		for(User u : users){
			deleteUser(u);
		}
	}
}