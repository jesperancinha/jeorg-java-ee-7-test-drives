package org.jesperancinha.jtd.jee.lightning4;

import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;
import org.jesperancinha.jtd.jee.lightning4.interceptors.RainInterceptor;
import org.jesperancinha.jtd.jee.lightning4.interceptors.SunInterceptor;

import javax.inject.Named;
import javax.interceptor.Interceptors;

@Named
public class NothingBean {
    @Interceptors({RainInterceptor.class, SunInterceptor.class})
    public void doNothing() {
        ConsolerizerGraphs.printRainbowFlag("Method doNothing is called!");
    }
}
