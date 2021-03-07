package org.jesperancinha.jtd.jee.vegetables;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class VegetableBean {
    private Long potatoWeight;
    private Long tomatoWeight;
    private Long chivesWeight;
    private Long carrotsWeight;
    private Long riceWeight;

   public VegetableBean() {
        this.potatoWeight = 10L;
        this.tomatoWeight = 20L;
        this.chivesWeight = 30L;
        this.carrotsWeight = 40L;
        this.riceWeight = 50L;
    }

    public Long getPotatoWeight() {
        return potatoWeight;
    }

    public void setPotatoWeight(Long potatoWeight) {
        this.potatoWeight = potatoWeight;
    }

    public Long getTomatoWeight() {
        return tomatoWeight;
    }

    public void setTomatoWeight(Long tomatoWeight) {
        this.tomatoWeight = tomatoWeight;
    }

    public Long getChivesWeight() {
        return chivesWeight;
    }

    public void setChivesWeight(Long chivesWeight) {
        this.chivesWeight = chivesWeight;
    }

    public Long getCarrotsWeight() {
        return carrotsWeight;
    }

    public void setCarrotsWeight(Long carrotsWeight) {
        this.carrotsWeight = carrotsWeight;
    }

    public Long getRiceWeight() {
        return riceWeight;
    }

    public void setRiceWeight(Long riceWeight) {
        this.riceWeight = riceWeight;
    }

    public Map<String, Object> getConfiguration() {
        final HashMap<String, Object> configuration = new HashMap<>();
        configuration.put("max", "50");
        configuration.put("min", "0");
        configuration.put("type", "number");
        configuration.put("required", "required");
        configuration.put("title", "Rice can maximum be 50Kg!");
        return configuration;
    }
}

