package charsheet.jsf;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

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
				
		System.out.println("Locale should be: " + locale);
		System.out.println("Locale is really: " + FacesContext.getCurrentInstance().getViewRoot().getLocale());
	}
	
    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        setLocale(language);
    }
    
    public void languageChanged(ValueChangeEvent e){
    	setLocale(e.getNewValue().toString());
    	FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
