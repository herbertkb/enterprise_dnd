package domain;

import java.io.Serializable;

import javax.inject.Inject;

import charsheet.entities.PlayerCharacter;
import charsheet.services.logging.LogCharacterChange;
import charsheet.services.storage.CharacterStorage;
import charsheet.services.storage.PlayerCharacters;

public class HpChangerImpl implements HpChanger, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@PlayerCharacters
	CharacterStorage characters;

	@Override
	@LogCharacterChange
	public int changeHP(PlayerCharacter pc, int howMuch) {

		int currentHP = pc.getHp();
		int newHP = currentHP + howMuch;
		pc.setHp(newHP);
		characters.modifyCharacter(pc);

		return newHP;
	}

}
