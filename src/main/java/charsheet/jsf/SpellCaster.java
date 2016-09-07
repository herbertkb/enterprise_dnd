package charsheet.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import charsheet.services.events.EffectThrower;

@Model
public class SpellCaster {

	@Inject
	EffectThrower thrower;
	
	private int casterLevel;

	public String fireball(){
		
		thrower.fireball(casterLevel);		
		return "index";	
	}
	
	@PostConstruct
	private void initCasterLevel(){
		casterLevel = 1;
	}
	
	public int getCasterLevel() {
		return casterLevel;
	}

	public void setCasterLevel(int casterLevel) {
		this.casterLevel = casterLevel;
	}
}
