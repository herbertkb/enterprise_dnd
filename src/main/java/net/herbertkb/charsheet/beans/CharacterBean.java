package net.herbertkb.charsheet.beans;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;

import net.herbertkb.charsheet.domain.PlayerCharacter;

@Stateless
@Named
public class CharacterBean {

	@PersistenceContext
	EntityManager em;
	
	public int changeHP( PlayerCharacter pc, int howMuch) {
		int newHP = pc.getHp() + howMuch;
		pc.setHp( newHP);
		em.merge( pc );
		
		return newHP;
	}
	

}
