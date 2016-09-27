package charsheet.services.storage;

import java.io.Serializable;

import javax.inject.Inject;

import charsheet.entities.PlayerCharacter;
import charsheet.services.logging.LogCharacterChange;

@LogCharacterChange
public class CharacterChangerImpl implements CharacterChanger, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@PlayerCharacters
	CharacterStorage characters;

	@Override
	public int changeHP(PlayerCharacter pc, int howMuch) {

		int currentHP = pc.getHp();
		int newHP = currentHP + howMuch;
		pc.setHp(newHP);
		characters.modifyCharacter(pc);

		return newHP;
	}
	
	
	public int incrementPlayerLevel(PlayerCharacter pc) {
		int currentLevel = pc.getLevel();
		pc.setLevel(currentLevel + 1);
		characters.modifyCharacter(pc);
		
		return pc.getLevel();
	}

}
