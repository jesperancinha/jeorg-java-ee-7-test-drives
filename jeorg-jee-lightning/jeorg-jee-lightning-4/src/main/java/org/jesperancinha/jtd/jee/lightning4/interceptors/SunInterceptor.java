package org.jesperancinha.jtd.jee.lightning4.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

public class SunInterceptor {
    @AroundInvoke
    public Object hereComesTheSun(InvocationContext invocationContext) throws Exception {
        YELLOW.printGenericLn("The sun is coming!");
        invocationContext.proceed();
        return "Big Sun!";
    }
}
