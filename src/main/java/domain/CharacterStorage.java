package domain;

import java.util.List;

public interface CharacterStorage {
	
	public void addCharacter(PlayerCharacter pc);
	
	public void modifyCharacter(PlayerCharacter pc);
	
	public PlayerCharacter getCharacter(String name);
	
	public void deleteCharacter(String name);
	
	public List<PlayerCharacter> getAll();
	
}
