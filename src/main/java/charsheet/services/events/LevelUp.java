package charsheet.services.events;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class LevelUp {
	
	private String forWhom;

	public String getForWhom() {
		return forWhom;
	}

	public void setForWhom(String forWhom) {
		this.forWhom = forWhom;
	}

}
