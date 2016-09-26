package charsheet.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import charsheet.services.events.LevelUp;
import charsheet.services.events.LevelUpEvent;


@Model
public class LevelUpper {
	
	private String characterName;
	
	@Inject private Event<LevelUpEvent> event;
	@Inject private LevelUp lu;
	
	public String levelUp() {
		
		lu.setForWhom(characterName);
		event.fire(new LevelUpEvent());
		
		return "index";
	}
	
	@PostConstruct
	public void init() {
		characterName = "";
	}
	
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
	
	
}
