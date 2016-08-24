package view;


import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import domain.BaseStats;
import domain.PlayerCharacter;
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
		
		conversation.end();
		
		return "index";
	}
	
}
