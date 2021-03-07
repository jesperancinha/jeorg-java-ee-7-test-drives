package org.jesperancinha.jtd.jee.lightning4;

import java.io.Serializable;

public class Tea implements Serializable {

    private String name;

    private Long quality;

    public Tea(String name, Long quality) {
        this.name = name;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuality() {
        return quality;
    }

    public void setQuality(Long quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "name='" + name + '\'' +
                ", quality=" + quality +
                '}';
    }
}
