package charsheet.services.events;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Path;

import charsheet.services.Dice;

@Stateless
@Path("effects")
public class EffectThrower {
	
	@EJB
	Dice dice;
	
	@Inject Event<Integer> hpChange;
	
	public void fireball(int casterLevel) {
		
		if (casterLevel > 10) casterLevel = 10;
		
		int damage = Integer.parseInt(dice.rollDice(casterLevel, 6));
		
		System.out.println("Fireball! CL: " + casterLevel + " DMG: " + damage);
		
		hpChange.fire( damage * (-1) );
		
	}
	
	
	//public void massHeal
	
	

}
