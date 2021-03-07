package org.jesperancinha.jtd.jee.mastery1.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class DiscographyBean implements Serializable {

    private List<String> discographyFirstTwo;

    public DiscographyBean() {
        this.discographyFirstTwo = new ArrayList<>();
    }

    public void submit() {
        this.discographyFirstTwo.add("Submit -> 2. Dorian edited their second album in 2006 entitled El futuro no es de nadie");

    }

    public void listener(ActionEvent actionEvent) {
        this.discographyFirstTwo.add("Listener -> 1. Dorian edited their first album in 2004 entitled 10.000 metrópolis");
    }

    public List<String> getDiscographyFirstTwo() {
        return discographyFirstTwo;
    }

    public void setDiscographyFirstTwo(List<String> discographyFirstTwo) {
        this.discographyFirstTwo = discographyFirstTwo;
    }
}
