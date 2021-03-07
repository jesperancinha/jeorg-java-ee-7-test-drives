package org.jesperancinha.jtd.jee.teeth.domain;

public enum ToothType {
    INCISOR,
    CANINE,
    MOLAR,
    PRE_MOLAR,
    WISDOM_MOLAR;

    public static ToothType getRandom() {
        final ToothType[] values = ToothType.values();
        var len = values.length;
        final double index = Math.random() * len;
        return values[(int) index];
    }
}
