package charsheet.services.storage;

import charsheet.entities.PlayerCharacter;

public interface CharacterChanger {
	public int changeHP(PlayerCharacter pc, int howMuch);
	public int incrementPlayerLevel(PlayerCharacter pc);
}
