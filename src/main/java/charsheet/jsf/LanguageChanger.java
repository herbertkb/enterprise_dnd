package charsheet.jsf;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LanguageChanger {
	
	private Locale locale;
	
	public Locale getLocale() {
		return locale;
	}

	public String changeLanguage(String code){
		System.out.println("Language is now:" 
				+ FacesContext.getCurrentInstance().getViewRoot().getLocale() );
		System.out.println("Changing lang to " + code + "...");
		
		locale = new Locale(code);
		FacesContext.getCurrentInstance().getViewRoot()
			.setLocale( locale );
		
		System.out.println("Language is now:" 
				+ FacesContext.getCurrentInstance().getViewRoot().getLocale() );
		
		return null;
	}
}
