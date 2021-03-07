package org.jesperancinha.jtd.jee.mastery1.servlet.marshal;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;

public class RecordValidatorEventHandler implements ValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        printRainbowTitleLn(event);
        return true;
    }
}
