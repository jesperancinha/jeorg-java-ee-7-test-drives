package org.jesperancinha.jtd.jee.portugal.beans;

import java.util.List;
import java.util.Map;
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

    public static Map<String, List<String>> getKingsMap() {
        final var kingsMap = Map.of(
                "Afonso I", List.of("The Conqueror", "The Great", "The Founder", "El-Bortukali", "Ibn-Arrink"),
                "Sancho I", List.of("The Populator"),
                "Afonso II", List.of("The Fat"),
                "Sancho II", List.of("The Pious"),
                "Afonso III", List.of("The Boulonnais"),
                "Dinis I", List.of("The Farmer", "The Poet"),
                "Afonso IV", List.of("The Brave"),
                "Pedro I", List.of("The Just", "The Cruel"),
                "Fernando I", List.of("The Handsome")
        );
        return kingsMap;
    }
}
