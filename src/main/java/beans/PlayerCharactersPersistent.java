package beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import domain.CharacterStorage;
import domain.PlayerCharacter;
import domain.PlayerCharacters;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Alternative
@PlayerCharacters
@Stateless
public class PlayerCharactersPersistent implements CharacterStorage {
	
	@PersistenceContext
	private EntityManager em;



	@Override
	public void addCharacter(PlayerCharacter pc) {
		em.persist(pc);
	}

	@Override
	public void modifyCharacter(PlayerCharacter pc) {
		em.persist(pc);
	}

	@Override
	public PlayerCharacter getCharacter(String name) {
		
		// Gross. Is there a cleaner way than this?
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PlayerCharacter> criteria = builder.createQuery(PlayerCharacter.class);
		Root<PlayerCharacter> root = criteria.from(PlayerCharacter.class);
		TypedQuery<PlayerCharacter> query = em
				.createQuery(criteria.select(root).where(
						builder.equal(root.<String> get("name"), name)));
		
		try{
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void deleteCharacter(String name) {
		PlayerCharacter pc = getCharacter(name);
		
		if(pc != null) {
			em.remove(pc);
		}
	}

	@Override
	public List<PlayerCharacter> getAll() {
		CriteriaQuery<PlayerCharacter> criteria = em.getCriteriaBuilder()
				.createQuery(PlayerCharacter.class);
		
		
		return em.createQuery(
				criteria.select(criteria.from(PlayerCharacter.class)))
				.getResultList();
	}

}
