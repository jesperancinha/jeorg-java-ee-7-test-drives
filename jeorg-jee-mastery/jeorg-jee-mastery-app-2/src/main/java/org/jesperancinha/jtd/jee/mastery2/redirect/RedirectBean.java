package org.jesperancinha.jtd.jee.mastery2.redirect;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static javax.faces.event.PhaseId.RENDER_RESPONSE;

@Named
@SessionScoped
public class RedirectBean implements Serializable {

    public void redirect() throws IOException {
        final FacesContext currentInstance = FacesContext.getCurrentInstance();
        currentInstance.setCurrentPhaseId(RENDER_RESPONSE);
        PhaseId.VALUES.forEach(ConsolerizerColor.MAGENTA::printGenericLn);
        PhaseId.VALUES.stream()
                .map(PhaseId::getName)
                .forEach(ConsolerizerColor.BRIGHT_MAGENTA::printGenericLn);
        ExternalContext externalContext = currentInstance.getExternalContext();
        externalContext.redirect("http://joaofilipesabinoesperancinha.nl");
    }
}
