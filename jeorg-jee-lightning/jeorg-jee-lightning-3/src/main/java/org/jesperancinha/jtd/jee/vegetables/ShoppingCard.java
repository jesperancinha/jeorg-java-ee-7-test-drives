package org.jesperancinha.jtd.jee.vegetables;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;

@Named
@RequestScoped
public class ShoppingCard {

    private boolean buyBeans;

    private boolean buyLentils;

    private boolean buyAlmonds;

    private String[] seeds;

    private String[] plants;

    private String grownPlant;

    private String greenPlant;

    private String bestPlant;

    private String superPlant;

    private List<String> selectedPlant;

    private List<Plant> plantDetails = Arrays.asList(
            new Plant("Bean Plant", 10L, "Red"),
            new Plant("Lentil Plant", 20L, "Blue"),
            new Plant("Chickpea Plant", 30L, "Yellow"));

    public boolean isBuyAlmonds() {
        return buyAlmonds;
    }

    public boolean isBuyBeans() {
        return buyBeans;
    }

    public boolean isBuyLentils() {
        return buyLentils;
    }

    public void setBuyAlmonds(boolean buyAlmonds) {
        this.buyAlmonds = buyAlmonds;
    }

    public void setBuyBeans(boolean buyBeans) {
        this.buyBeans = buyBeans;
    }

    public void setBuyLentils(boolean buyLentils) {
        this.buyLentils = buyLentils;
    }

    public void sendOrder() {
        BRIGHT_BLUE.printGenericLn(toString());
    }

    public String[] getSeeds() {
        return seeds;
    }

    public void setSeeds(String[] seeds) {
        this.seeds = seeds;
    }

    public String[] getPlants() {
        return plants;
    }

    public void setPlants(String[] plants) {
        this.plants = plants;
    }

    public List<Plant> getPlantDetails() {
        return plantDetails;
    }

    public void setSelectedPlant(List<String> selectedPlant) {
        this.selectedPlant = selectedPlant;
    }

    public List<String> getSelectedPlant() {
        return selectedPlant;
    }

    public void setPlantDetails(List<Plant> plantDetails) {
        this.plantDetails = plantDetails;
    }

    public String getGrownPlant() {
        return grownPlant;
    }

    public void setGrownPlant(String grownPlant) {
        this.grownPlant = grownPlant;
    }

    public String getBestPlant() {
        return bestPlant;
    }

    public void setBestPlant(String bestPlant) {
        this.bestPlant = bestPlant;
    }

    public String getGreenPlant() {
        return greenPlant;
    }

    public void setGreenPlant(String greenPlant) {
        this.greenPlant = greenPlant;
    }

    public String getSuperPlant() {
        return superPlant;
    }

    public void setSuperPlant(String superPlant) {
        this.superPlant = superPlant;
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "buyBeans=" + buyBeans +
                ", buyLentils=" + buyLentils +
                ", buyAlmonds=" + buyAlmonds +
                ", seeds=" + Arrays.toString(seeds) +
                ", plants=" + Arrays.toString(plants) +
                ", grownPlant='" + grownPlant + '\'' +
                ", greenPlant='" + greenPlant + '\'' +
                ", bestPlant='" + bestPlant + '\'' +
                ", superPlant='" + superPlant + '\'' +
                ", selectedPlant=" + selectedPlant +
                ", plantDetails=" + plantDetails +
                '}';
    }
}
