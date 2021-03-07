package org.jesperancinha.jtd.jee.app2.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "herb")
@XmlAccessorType(XmlAccessType.FIELD)
public class Herb implements Serializable {

    private String name;

    private String color;

    private Long grams;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGrams(Long grams) {
        this.grams = grams;
    }

    public String toString() {
        return String.format("Herb name is %s and has color %s and we have %d grams of it", name, color, grams);
    }
}
