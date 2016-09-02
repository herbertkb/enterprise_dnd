package charsheet.jsf;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import charsheet.entities.PlayerCharacter;
import charsheet.services.storage.CharacterStorage;
import charsheet.services.storage.PlayerCharacters;

@ApplicationScoped
@Named("characterSheets")
public class Characters {
	
	@Inject
	//@EJB
	@PlayerCharacters
	CharacterStorage characters;
	
	
	public List<PlayerCharacter> getPlayerSheets(){
		return characters.getAll();
	}
	

}
