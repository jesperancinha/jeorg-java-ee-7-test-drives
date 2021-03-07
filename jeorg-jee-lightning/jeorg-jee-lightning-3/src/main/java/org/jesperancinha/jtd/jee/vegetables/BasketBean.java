package org.jesperancinha.jtd.jee.vegetables;

import com.sun.faces.facelets.compiler.UILiteralText;
import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

@Named
@SessionScoped
public class BasketBean implements Serializable {

    private String vegetable;

    private String message1;

    private String message2;

    private UILiteralText component = new UILiteralText("");

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public void activateVegetable() {
        ConsolerizerColor.BRIGHT_RED.printGenericLn("%s activated!", vegetable);
        if (Objects.isNull(vegetable)) {
            message1 = "I think you just clicked in the immediate button. Since the value is submitted before evaluation, it never changes in the backend";
        } else {
            message1 = String.format("Your value is now %s", vegetable);
            message2 = "If you clicked on immediate, and changed the input box, you'll notice that the value doesn't get updated"
                    .concat("\n")
                    .concat("If clicked on false immediate, and changed the input, you'll notice an immediate change")
                    .concat("\n")
                    .concat("Either way, only you as a user, knows which button has been pressed. I'm in the back end, so I don't know that.");
        }
        this.component = new UILiteralText(vegetable);
    }

    public String getMessage1() {
        return message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UILiteralText component) {
        this.component = component;
    }
}
