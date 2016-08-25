package view;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.CharacterStorage;
import domain.PlayerCharacter;
import domain.PlayerCharacters;

@ApplicationScoped
@Named("characterSheets")
public class Characters {
	
	@Inject
	@EJB
	@PlayerCharacters
	CharacterStorage characters;
	
	
	public List<PlayerCharacter> getPlayerSheets(){
		return characters.getAll();
	}
	

}
