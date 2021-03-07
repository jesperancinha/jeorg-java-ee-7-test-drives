package org.jesperancinha.jtd.jee.united.kingdom.bean;

public class Monarch {

    private String name;

    private String family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Monarch{" + "name='" + name + '\'' + ", family='" + family + '\'' + '}';
    }
}
