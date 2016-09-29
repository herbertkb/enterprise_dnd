package charsheet.services.logging;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import charsheet.entities.UserData;

@Interceptor
@LogUserPersistence
public class UserPersistenceLogger {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		
		Object[] params = ic.getParameters();
		UserData u = (UserData) params[0];
		
		System.out.println(u);
				
		return ic.proceed();
	}

}
