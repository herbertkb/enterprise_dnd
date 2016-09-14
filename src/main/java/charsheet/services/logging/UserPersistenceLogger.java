package charsheet.services.logging;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import charsheet.entities.User;

@Interceptor
@LogUserPersistence
public class UserPersistenceLogger {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		
		Object[] params = ic.getParameters();
		User u = (User) params[0];
		
		System.out.println(u);
				
		return ic.proceed();
	}

}
