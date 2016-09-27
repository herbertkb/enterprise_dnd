package charsheet.jsf;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import charsheet.services.storage.CharacterStorage;
import charsheet.services.storage.PlayerCharacters;

@Model
public class PCNameValidator implements Validator {

	@Inject
	@PlayerCharacters
	private CharacterStorage sheets;
	
	final String warningMessage = "Who dat?";
	
	@Override
	public void validate(	FacesContext context, 
							UIComponent component, 
							Object value) throws ValidatorException {
		
		String name = value.toString();
						
		if (!sheets.exists(name)){
			FacesMessage warning = new FacesMessage(warningMessage);
			warning.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(warning);
		}
	}
}
