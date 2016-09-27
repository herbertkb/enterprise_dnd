package charsheet.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */

// TODO: refactor as "Player" instead of as "User"

@Entity
public class User implements Serializable {

	
	@Id private String username;
	private String role;
	private String password;
	private boolean remembered;
	private boolean loggedIn;
	
	
	// TODO: Helper methods / JPQL queries for retrieving characters beloning to player
	@OneToMany
	private Set<PlayerCharacter> characters;
	
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemembered() {
		return remembered;
	}
	public void setRemembered(boolean remembered) {
		this.remembered = remembered;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", role=" + role + "]";
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}
