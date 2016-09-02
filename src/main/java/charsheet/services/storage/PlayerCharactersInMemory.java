package charsheet.services.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import charsheet.entities.PlayerCharacter;
import charsheet.services.logging.LogCharacterChange;;

@Alternative
@Default
@Singleton
@PlayerCharacters
@Lock(LockType.WRITE)
public class PlayerCharactersInMemory implements CharacterStorage {
	private Map<String, PlayerCharacter > playerCharacters;
	
	@PostConstruct
	final private void startingCharacters() {
		
		playerCharacters = new HashMap<String, PlayerCharacter>();
		
	}

	@Override
	@LogCharacterChange
	public void addCharacter(PlayerCharacter pc) {
		playerCharacters.put(pc.getName(), pc);
	}

	@Override
	@LogCharacterChange
	public void modifyCharacter(PlayerCharacter pc) {
		playerCharacters.put(pc.getName(), pc);		
	}

	@Override
	public PlayerCharacter getCharacter(String name) {
		return playerCharacters.get(name);
	}

	@Override
	public void deleteCharacter(String name) {
		playerCharacters.remove(name);		
	}

	@Override
	public List<PlayerCharacter> getAll() {
		return new ArrayList<PlayerCharacter>( playerCharacters.values() );
	}
}
