package domain;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import beans.Dice;

public class EffectThrower {
	
	@EJB
	Dice dice;
	
	@Inject Event<Integer> hpChange;
	
	public void fireball(int casterLevel) {
		
		if (casterLevel > 10) casterLevel = 10;
		
		int damage = Integer.parseInt(dice.rollDice(casterLevel, 6));
		
		System.out.println("CL: " + casterLevel + " DMG: " + damage);
		
		hpChange.fire( damage * (-1) );
		
	}
	
	

}
