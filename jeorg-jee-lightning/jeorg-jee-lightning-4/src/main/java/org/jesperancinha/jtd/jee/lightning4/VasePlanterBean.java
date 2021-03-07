package org.jesperancinha.jtd.jee.lightning4;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class VasePlanterBean implements Serializable {

    @Inject
    private VasePlanter vasePlanter;

    private String planted;

    public String getPlantedPlant() {
        return vasePlanter.getPlantedPlant();
    }

    public void setPlantedPlant() {
        vasePlanter.setPlantedPlant(planted);
    }

    public String getPlanted() {
        return planted;
    }

    public void setPlanted(String planted) {
        this.planted = planted;
    }
}
