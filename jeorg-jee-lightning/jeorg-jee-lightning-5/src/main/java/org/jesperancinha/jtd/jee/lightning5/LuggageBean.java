package org.jesperancinha.jtd.jee.lightning5;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Remote(Luggage.class)
public class LuggageBean implements Luggage{

    private List<String> inside = new ArrayList<>();
    @Override
    public List<String> contents() {
        return inside;
    }

    @Override
    public void addItem(String item) {
        inside.add(item);
    }
}
