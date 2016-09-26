package charsheet.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

@Model
public class Dungeon {
	
	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = (level > 0) 
						?  level
						: level * -1;
	}
	
	@PostConstruct
	void initialize(){
		setLevel(1);
	}
}
