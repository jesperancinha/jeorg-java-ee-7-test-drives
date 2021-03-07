package org.jesperancinha.jtd.jee.vegetables;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.printRainbowFlag;

@Named
@RequestScoped
public class MagicBean {
    private Byte nBeans;
    public Byte getnBeans() {
        return nBeans;
    }
    public void setnBeans(Byte nBeans) {
        this.nBeans = nBeans;
    }
    public void activateBeans() {
        BRIGHT_BLUE.printGenericLn("You have activated %s bean(s)", nBeans);
    }
    public void magicValidator(javax.faces.context.FacesContext facesContext, javax.faces.component.UIComponent uiComponent, java.lang.Object beanValue) {
        Byte byteBeanValue = (Byte) beanValue;
        int primeCount = 0;
        for (int i = 2; i < byteBeanValue; i++) {
            if (byteBeanValue % i == 0) {
                primeCount++;
            }
        }
        if (primeCount != 0) {
            FacesMessage msg = new FacesMessage(
                    "You can only have prime magic bean numbers!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
    }
    public void beanChange(ValueChangeEvent valueChangeEvent) {
        RED.printGenericLn("Value has changed from %s to %s", valueChangeEvent.getOldValue(), valueChangeEvent.getNewValue());
        printRainbowFlag(valueChangeEvent.getNewValue().toString());
    }
}
