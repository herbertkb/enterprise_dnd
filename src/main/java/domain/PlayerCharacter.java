package domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Character
 *
 */
@Entity
public class PlayerCharacter implements Serializable {
	
	@Id 
	@Column
	@NotEmpty(message = "A character must have a name.")
	private String name;
	
	@Column private int hp;
	@Column private String race;		//TODO: replace with an enum
	@Column private String cclass;		//TODO: replace with an enum
	@Column private int level;
	
	private BaseStats basestats;

	private static final long serialVersionUID = 1L;

	public PlayerCharacter() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}   
	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}   
	public String getCclass() {
		return this.cclass;
	}

	public void setCclass(String cclass) {
		this.cclass = cclass;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public BaseStats getBasestats() {
		return basestats;
	}
	public void setBasestats(BaseStats basestats) {
		this.basestats = basestats;
	}
	@Override
	public String toString() {
		return "PlayerCharacter [name=" + name + ", hp=" + hp + ", race=" + race + ", cclass=" + cclass + ", level="
				+ level + ", basestats=" + basestats + "]";
	}
	
	
	
   
}
