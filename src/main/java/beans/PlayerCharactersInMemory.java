package beans;

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

import domain.CharacterStorage;
import domain.PlayerCharacter;
import domain.PlayerCharacters;;

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
		
		PlayerCharacter notEmpty = new PlayerCharacter();
		notEmpty.setName("Not Empty");
		
		addCharacter(notEmpty);
	}

	@Override
	public void addCharacter(PlayerCharacter pc) {
		playerCharacters.put(pc.getName(), pc);
	}

	@Override
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
