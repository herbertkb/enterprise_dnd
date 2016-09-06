package charsheet.services.storage;

import java.io.Serializable;

import javax.ejb.EJB;

import charsheet.entities.PlayerCharacter;
import charsheet.services.Dice;


public class HPInitializer implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	Dice dice;

	public void initializeHP(PlayerCharacter pc) {
		
		int hitDice;
		switch( pc.getCclass() ) {		//TODO: replace with enum or something
		case "fighter":
			hitDice = 10; break;
		case "cleric":
			hitDice = 8; break;
		case "rogue":
			hitDice = 6; break;
		default:
			hitDice = 4;
		}
		
		int conBonus = (pc.getBasestats().getCON() - 10) / 2;
		
		int hp = hitDice;
		hp += Integer.parseInt( dice.rollDice( (pc.getLevel() -1 ) , hitDice));
		hp += conBonus * pc.getLevel();
		
		pc.setHp(hp);
	}

}
