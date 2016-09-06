package charsheet.services.events;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import charsheet.entities.PlayerCharacter;
import charsheet.services.storage.CharacterStorage;
import charsheet.services.storage.HpChanger;
import charsheet.services.storage.PlayerCharacters;

public class EffectListener {
	
	@Inject
	@PlayerCharacters
	CharacterStorage sheets;
	
	@Inject HpChanger changer;
	
	
	public void fireballListener(@Observes @Any Integer damage){
		
		List<PlayerCharacter> PCs = sheets.getAll();
		
		for(PlayerCharacter p : PCs){
			changer.changeHP(p, damage);
		}
		
	}

}
