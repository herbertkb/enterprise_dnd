package charsheet.services.logging;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import charsheet.entities.PlayerCharacter;

@LogCharacterChange
@Interceptor
public class CharacterChangeLogger {
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		
		Object[] params = ic.getParameters();
		Object param = params[0];
		
		PlayerCharacter pc = (PlayerCharacter) param;
		
		System.out.println("Character changed from: " + pc);
		
		ic.proceed();
		
		System.out.println("Character changed to: " + pc);

		return null;
	}

}
