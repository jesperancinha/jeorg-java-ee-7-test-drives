package org.jesperancinha.jtd.jee.spain.bundle;

import java.util.ListResourceBundle;

public class Bundle_Es extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"count.one", "Uno"},
            {"count.two", "Dos"},
            {"count.three", "Tres"},
    };
}
