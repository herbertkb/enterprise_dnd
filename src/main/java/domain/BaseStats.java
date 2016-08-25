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
		
		//int[] dice = new int[4];
		
		Integer[] dice = new Integer[4];
				
		System.out.println("Initial: " + Arrays.toString(dice));

//		for(int i = 0; i < dice.length; i++) {
//			dice[i] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
//			System.out.println(dice[i]);
//		}

		for(Integer d : dice){
			d = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		}
		
		System.out.println("Rolled: " + Arrays.toString(dice));
		
		Arrays.sort(dice);
		
		System.out.println("Sorted: " + Arrays.toString(dice));

		
		Integer[] best = Arrays.copyOfRange(dice, 1, 4);
		
		System.out.println("Sliced: " + Arrays.toString(best));

		
		int stat = 0;
		for(int roll : best){			
			stat += roll;
		}
		
		System.out.println("Sum:" + stat);
		
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
