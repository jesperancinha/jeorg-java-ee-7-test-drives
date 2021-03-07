package org.jesperancinha.jtd.jee.lightning4;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;

@FacesComponent(createTag = true,
        tagName = "uiInput3Ps",
        namespace = "https://org.jesperancinha/tags")
public class UIInput3Ps extends UIComponentBase {

    @Override
    public String getFamily() {
        return "Tickets";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        final var ticket = (String) getAttributes().get("ticket");
        final var order = (String) getAttributes().get("order");

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("p", this);
        writer.write("You are seeing this ticket via a custom component");
        writer.endElement("p");

        writer.startElement("p", this);
        writer.write(String.format("Your ticket is: %s", ticket));
        writer.endElement("p");

        writer.startElement("p", this);
        writer.write(String.format("You've ordered %s elements", order));
        writer.endElement("p");
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        final ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("p", this);
        responseWriter.write("And this is the End of the rendering");
        responseWriter.endElement("p");
    }
}