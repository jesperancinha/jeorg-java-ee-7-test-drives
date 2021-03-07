package org.jesperancinha.jtd.jee.vegetables;

import javax.enterprise.context.RequestScoped;

public class Plant {
    private String plant;

    private Long height;

    private String vaseColor;

    public Plant(final String plant,
                 final Long height,
                 final String vaseColor){
        this.plant = plant;
        this.height = height;
        this.vaseColor = vaseColor;

    }
    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getVaseColor() {
        return vaseColor;
    }

    public void setVaseColor(String vaseColor) {
        this.vaseColor = vaseColor;
    }
}
