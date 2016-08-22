package net.herbertkb.charsheet.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.Min;
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
	
	@Column @Min(0) private int str;
	@Column @Min(0) private int dex;
	@Column @Min(0) private int con;
	@Column @Min(0) private int wis;
	@Column @Min(0) private int intel;
	@Column @Min(0) private int cha;

	
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
	
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public int getWis() {
		return wis;
	}
	public void setWis(int wis) {
		this.wis = wis;
	}
	public int getIntel() {
		return intel;
	}
	public void setIntel(int intel) {
		this.intel = intel;
	}
	public int getCha() {
		return cha;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
   
}
