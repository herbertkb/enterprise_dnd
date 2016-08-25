package domain;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class HpChangerImpl implements HpChanger {

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
	
}
