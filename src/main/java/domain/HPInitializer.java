package domain;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.ejb.EJB;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import beans.Dice;

@Decorator
public class HPInitializer implements HpChanger {

	@Inject
	@Delegate
	@Any
	private HpChanger hpChanger;
	
	@EJB
	Dice dice;

	@Override
	public int changeHP(PlayerCharacter pc, int howMuch) {
		
		if (howMuch != 0) return hpChanger.changeHP(pc, howMuch);
		
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
		
		howMuch = hitDice;
		howMuch += Integer.parseInt( dice.rollDice( (pc.getLevel() -1 ) , hitDice));
		howMuch += conBonus * pc.getLevel();
		
		return hpChanger.changeHP(pc, howMuch);
	}

}
