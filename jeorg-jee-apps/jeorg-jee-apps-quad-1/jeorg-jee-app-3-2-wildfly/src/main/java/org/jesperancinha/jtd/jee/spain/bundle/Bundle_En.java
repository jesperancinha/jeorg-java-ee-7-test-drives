package org.jesperancinha.jtd.jee.spain.bundle;

import java.util.ListResourceBundle;

public class Bundle_En extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"count.one", "One"},
            {"count.two", "Two"},
            {"count.three", "Three"},
    };
}
