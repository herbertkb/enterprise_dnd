package domain;

import charsheet.entities.PlayerCharacter;

public interface HpChanger {
	public int changeHP(PlayerCharacter pc, int howMuch);
}
