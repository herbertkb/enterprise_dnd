package charsheet.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	
	@Id private String username;
	private String role;
	private String password;
	private boolean remembered;
	
	
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
	
	
   
}
