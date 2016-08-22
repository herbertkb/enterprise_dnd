package net.herbertkb.charsheet.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerCharacterDatabase implements Serializable {
	
	private final static Map<String, PlayerCharacter> PCs 
			= new HashMap<String, PlayerCharacter>();
	
	/**
	 * Lookup a PC by name.
	 * @param pcName
	 * @return NULL if not not found, else {@link PlayerCharacter}
	 */
	public PlayerCharacter lookupPC( String name ){
		return PCs.get(name);
	}
	
	/**
	 * Add or update a PC entry
	 * @param PlayerCharacter pc
	 */
	public void updatePC( PlayerCharacter pc ){
		PCs.put(pc.getName(), pc);
	}
	

}
