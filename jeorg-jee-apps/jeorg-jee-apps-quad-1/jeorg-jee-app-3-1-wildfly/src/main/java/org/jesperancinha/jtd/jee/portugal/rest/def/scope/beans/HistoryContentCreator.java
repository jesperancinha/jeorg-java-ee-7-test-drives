package org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans;

import java.util.Stack;

public class HistoryContentCreator {

    public static Stack<String> stackOfEvents1() {
        final var events = new Stack<String>();
        events.add("Homo heidelbergensis");
        events.add("Lusitanians, Turduli and Oestriminis");
        events.add("Romans");
        events.add("Kingdom of the Suebi");
        events.add("Visigothic Kingdom");
        events.add("Umayyad Caliphate");
        events.add("Battle of Tours");
        events.add("Portus Cale");
        events.add("County of Portugal and the County of Coimbra");
        events.add("Vimarens as capital of Portugal");
        return events;
    }
}
