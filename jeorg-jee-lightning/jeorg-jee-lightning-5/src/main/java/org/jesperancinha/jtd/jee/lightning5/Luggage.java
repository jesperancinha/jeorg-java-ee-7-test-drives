package org.jesperancinha.jtd.jee.lightning5;

import java.util.List;

public interface Luggage {
    List<String> contents();

    void addItem(String item);
}
