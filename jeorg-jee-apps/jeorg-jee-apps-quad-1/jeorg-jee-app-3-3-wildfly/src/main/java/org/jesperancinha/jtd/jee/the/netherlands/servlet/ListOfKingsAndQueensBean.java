package org.jesperancinha.jtd.jee.the.netherlands.servlet;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@Stateless
public class ListOfKingsAndQueensBean {

    @RolesAllowed({"Manager", "Civilian"})
    public List<String> getOrangeNassau() {
        return Arrays.asList("Willem I", "Maurice", "Frederik Hendrik", "Willem II", "Willem III", "Willem IV",
                "Willem V");
    }

    @RolesAllowed({"Manager"})
    public List<String> getNassau() {
        GREEN.printGenericLn("Note that this method is anotated with @RolesAllowed: Manager");
        GREEN.printGenericLn("If you are admin2, you ony have Civilian role");
        GREEN.printGenericLn("This happens because ejb-jar.xml overrides every annotation configuration");
        return Arrays.asList("Jan VI", "Willem Lodewijk", "Ernst Casimir I", "Hendrik Casimir I", "Willem Frederik",
                "Hendrik Casimir II", "Johan Willem Friso");
    }
}
