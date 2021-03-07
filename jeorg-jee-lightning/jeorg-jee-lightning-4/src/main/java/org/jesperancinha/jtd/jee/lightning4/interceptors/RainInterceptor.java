package org.jesperancinha.jtd.jee.lightning4.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

public class RainInterceptor {
    @AroundInvoke
    public Object hereComesTheRain(InvocationContext invocationContext) throws Exception {
        BLUE.printGenericLn("Here comes the rain!");
        invocationContext.proceed();
        return "Big Rain!";
    }
}
