package domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Entity implementation class for Entity: BaseStats
 *
 */
@Entity
public class BaseStats implements Serializable {
	
	@Id
	@Column
	private String characterId;

	@Min(0)
	@Max(30)
	@Column
	private int STR;

	@Min(0)
	@Max(30)
	@Column
	private int DEX;
	
	@Min(0)
	@Max(30)
	@Column
	private int CON;
	
	@Min(0)
	@Max(30)
	@Column
	private int WIS;
	
	@Min(0)
	@Max(30)
	@Column
	private int INT;
	
	@Min(0)
	@Max(30)
	@Column
	private int CHA;

	/*
	 * Roll 4 six-sided dice and return the sum of the three highest.
	 */
	private int rollStat(){
		
		int[] dice = new int[3];
		
		for(int d : dice) {
			d = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		}
		
		Arrays.sort(dice);
		int[] best = Arrays.copyOfRange(dice, 1, 3);
		
		int stat = 0;
		for(int roll : best){
			stat += roll;
		}
		
		return stat;
	}
	
	public BaseStats() {
				
		STR = rollStat();
		DEX = rollStat();
		CON = rollStat();
		WIS = rollStat();
		INT = rollStat();
		CHA = rollStat();
		
	}
	
	public String getCharacterId() {
		return characterId;
	}

	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}
	public int getSTR() {
		return this.STR;
	}

	public void setSTR(int STR) {
		this.STR = STR;
	}

	public int getDEX() {
		return DEX;
	}

	public void setDEX(int dEX) {
		DEX = dEX;
	}

	public int getCON() {
		return CON;
	}

	public void setCON(int cON) {
		CON = cON;
	}

	public int getWIS() {
		return WIS;
	}

	public void setWIS(int wIS) {
		WIS = wIS;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int iNT) {
		INT = iNT;
	}

	public int getCHA() {
		return CHA;
	}

	public void setCHA(int cHA) {
		CHA = cHA;
	}
}
