package charsheet.jsf;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import charsheet.services.storage.UserManager;

@Model
public class Login {

	@Inject Credentials credentials;
	@Inject UserManager users; 
	
	final String errorMsg = "problem";
	
	public String login(){
		HttpServletRequest request = (HttpServletRequest) FacesContext
										.getCurrentInstance()
										.getExternalContext()
										.getRequest();
		
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
		System.out.println("\n" + credentials.toString() + "\n");
		
		try {	
			request.login(username, password);
		} 
		catch (ServletException se){
			
			se.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage("loginForm", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMsg, ""));
			
			return null;
		}
		
		
		
		return "index";
	}
	
	public String logout(){
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try {
			request.logout();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "login";
	}
	
}
