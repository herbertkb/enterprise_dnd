package charsheet.jsf;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import charsheet.entities.User;
import charsheet.services.storage.UserManager;

@Model
public class Login {

	@Inject Credentials credentials;
	@Inject UserManager users;
	@Produces User user;
	
	final String errorMsg = "problem";
	
	public String login(){
		HttpServletRequest request = (HttpServletRequest) FacesContext
										.getCurrentInstance()
										.getExternalContext()
										.getRequest();
		
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
		try {	
			request.login(username, password);
		} 
		catch (ServletException se){	
			FacesContext.getCurrentInstance().addMessage("loginForm", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, ""));
			
			return null;
		}
		
		user = users.getUser(username);
		user.setLoggedIn(true);
		return "index";
	}
	
	public String logout(){
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
			return null;
		}
		
		user = null;
		HttpSession session = (HttpSession) FacesContext
												.getCurrentInstance()
												.getExternalContext()
												.getSession(false);
		session.invalidate();
		
		return "login";
	}
	
}
