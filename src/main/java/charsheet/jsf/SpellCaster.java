package charsheet.jsf;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import charsheet.services.events.EffectThrower;

@Model
public class SpellCaster {

	@Inject
	EffectThrower thrower;
	
	@Named
	@Produces
	private int casterLevel;
	
	public String fireball(){
		
		thrower.fireball(casterLevel);		
		return "index";
		
	}
}
