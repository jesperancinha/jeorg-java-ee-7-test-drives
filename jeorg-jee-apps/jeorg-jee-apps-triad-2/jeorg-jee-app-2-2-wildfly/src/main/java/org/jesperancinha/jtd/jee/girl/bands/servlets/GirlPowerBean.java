package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;

@Named("girlPowerBean")
@SessionScoped
public class GirlPowerBean implements Serializable {

    private boolean logged;

    @Inject
    private HttpSession httpSession;

    public void login() {
        BRIGHT_MAGENTA.printGenericLn("Logging in...");
        httpSession.setAttribute("LOGGED_IN", "Spice Girls");
        this.logged = true;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}