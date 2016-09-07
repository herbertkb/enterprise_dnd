package charsheet.jsf;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LanguageChanger {
	
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(String code){
		System.out.println("Locale was: " + locale);

		this.locale = new Locale(code);
				
		System.out.println("Locale is now: " + locale);
	}
}