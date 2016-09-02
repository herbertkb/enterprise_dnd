package charsheet.services;

import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/dice")
@Stateless
public class Dice {
	
	@GET
	@Path("/{dice:[0-9]+}d{sides:[0-9]+}")
	@Produces("text/plain")
	public String rollDice(
			@PathParam("dice") int dice,
			@PathParam("sides") int sides) {
				
		int score = 0;
		for(int i = 0; i < dice; i++ ) {
			score += ThreadLocalRandom.current().nextInt(1, sides + 1);
		}
		
		return new Integer(score).toString();
	}	
}
