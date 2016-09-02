package charsheet.services.storage;

import java.util.List;

import charsheet.entities.PlayerCharacter;

public interface CharacterStorage {
	
	public void addCharacter(PlayerCharacter pc);
	
	public void modifyCharacter(PlayerCharacter pc);
	
	public PlayerCharacter getCharacter(String name);
	
	public void deleteCharacter(String name);
	
	public List<PlayerCharacter> getAll();
	
}
