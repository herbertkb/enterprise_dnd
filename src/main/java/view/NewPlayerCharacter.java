package view;


import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import beans.Dice;
import domain.BaseStats;
import domain.CharacterStorage;
import domain.HpChanger;
import domain.PlayerCharacter;
import domain.PlayerCharacters;

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
	
	@EJB
	private HpChanger hpInitializer;
	
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
		
		// Set player to random level
		pc.setLevel( Integer.parseInt( dice.rollDice(1, 10)) );
		
		// Add to data store and initialize HP
		players.addCharacter(pc);
		hpInitializer.changeHP(pc, 0);
		
		// Done!
		conversation.end();
		return "index";
	}
	
}
