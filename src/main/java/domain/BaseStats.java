package domain;

import java.io.Serializable;
import java.util.Arrays;
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
	
	private static final long serialVersionUID = 1L;

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
	 * 
	 * This should be moved into an EJB or Utility class.
	 */
	private int rollStat(){
				
		// Roll 4 dice
		Integer[] dice = new Integer[4];
		for(int i = 0; i < dice.length; i++) {
			dice[i] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
			System.out.println(dice[i]);
		}
		
		// Pick the best 3
		Arrays.sort(dice);
		Integer[] best = Arrays.copyOfRange(dice, 1, 4);
	
		// Get the sum
		int stat = 0;
		for(int roll : best){			
			stat += roll;
		}
				
		return stat;
	}
	
	public BaseStats() {
				
		this.STR = rollStat();
		this.DEX = rollStat();
		this.CON = rollStat();
		this.WIS = rollStat();
		this.INT = rollStat();
		this.CHA = rollStat();
		
		System.out.println( STR + " " + DEX + " " + CON);
		
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
