package charsheet.services.storage;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import charsheet.entities.UserData;
import charsheet.services.logging.LogUserPersistence;

@Singleton
@Startup
public class UserManager {
	
	@PersistenceContext
	EntityManager em;
	
	@LogUserPersistence
	public void addUser(UserData u){
		em.persist(u);
		
		// TODO: fix UserPersistenceLogger intercepter and remove below
		System.out.println("Adding: " + u);	
	}
	
	@LogUserPersistence
	public void modifyUser(UserData u){
		em.merge(u);
	}
	
	@LogUserPersistence
	public void deleteUser(UserData u){
		em.remove(u);
		
		// TODO: fix UserPersistenceLogger intercepter and remove below
		System.out.println("Deleting: " + u);
	}
	
	public void deleteUser(String name) {
		UserData u = getUser(name);
		deleteUser(u);
	}
	
	public UserData getUser(String name){
		
		return em.find(UserData.class, name);
	}
	
	public List<UserData> getAllUsers(){
		
		CriteriaQuery<UserData> criteria = em.getCriteriaBuilder()
				.createQuery(UserData.class);
		
		return em.createQuery(
				criteria.select(criteria.from(UserData.class)))
				.getResultList();
	}
	
	public UserData validateUsernamePassword (String username, String password){
		UserData u = getUser(username);
		if (u.getPassword().equals(password)) {
			return u;
		}
		
		return null;
	}
	
	@PostConstruct
	private void initialUsers() {
		
		UserData player1 = new UserData();
		player1.setUsername("Timmy");
		player1.setPassword("pass");
		player1.setRole("player");
		
		UserData dm = new UserData();
		dm.setUsername("ComicBookGuy");
		dm.setPassword("pass");
		dm.setRole("dungeonmaster");
		
		addUser(player1);
		addUser(dm);
	}
	
	@PreDestroy
	private void teardownUsers(){
		List<UserData> users = getAllUsers();
		
		for(UserData u : users){
			deleteUser(u);
		}
	}
}