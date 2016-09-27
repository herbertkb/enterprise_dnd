package charsheet.jsf;


import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import charsheet.entities.BaseStats;
import charsheet.entities.PlayerCharacter;
import charsheet.services.Dice;
import charsheet.services.events.EffectThrower;
import charsheet.services.storage.CharacterStorage;
import charsheet.services.storage.HPInitializer;
import charsheet.services.storage.CharacterChanger;
import charsheet.services.storage.PlayerCharacters;

import java.io.Serializable;

@ConversationScoped
@Named("creater")
public class NewPlayerCharacter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Named("sheet")
	@Produces
	private PlayerCharacter pc = new PlayerCharacter();	

	@Named
	@Produces
	private BaseStats stats = new BaseStats();
	
	@Inject
	private Conversation conversation;
	
	@Inject
	@PlayerCharacters
	private CharacterStorage players;
	
	@Inject
	private HPInitializer hpInitializer;
	
	@EJB
	private Dice dice;
	
	public String rollStats() {
		stats = new BaseStats();
		
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		return "choose_stats";
	}	
	
	
	public String keepStats() {
		
		pc.setBasestats(stats);
		
		return "choose_race";
	}
	

	
	public String keepRace() {
		
		return "choose_class";
	}
	
	public String keepClass() {
		
		return "choose_name";
	}
	
	public String keepName() {
		
		// TODO: allow player to set level, apply JSF conversion/validation
		
		// Set player to random level
		pc.setLevel( Integer.parseInt( dice.rollDice(1, 10)) );
				
		// initialize HP and add to player storage
		hpInitializer.initializeHP(pc);
		players.addCharacter(pc);
		
		
		// Done!
		conversation.end();
		return "index";
	}
	
}
