package domain;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HpChangerImpl implements HpChanger, Serializable {

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
	
}
