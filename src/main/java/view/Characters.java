package view;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import domain.PlayerCharacter;

@ApplicationScoped
@Named("characterSheets")
public class Characters {
	
	public PlayerCharacter[] getPlayerSheets(){
		return null;
	}
	

}
