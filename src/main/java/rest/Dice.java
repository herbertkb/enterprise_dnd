package rest;

import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/dice")
public class Dice {
	
	@GET
	@Path("/{dice:[0-9]+}d{sides:[0-9]+}{sign: [\\+-]?}{modifier:[0-9]*}")
	@Produces("text/plain")
	public String rollDice(
			@PathParam("dice") int dice,
			@PathParam("sides") int sides,
			@PathParam("sign") char sign,
			@PathParam("modifier") int modifier) {
				
		int score = 0;
		for(int i = 0; i < dice; i++ ) {
			score += ThreadLocalRandom.current().nextInt(1, sides + 1);
		}
		
		modifier *= (sign == '+') ? 1 : -1;
		score += modifier;
		
		return new Integer(score).toString();
	}
}
