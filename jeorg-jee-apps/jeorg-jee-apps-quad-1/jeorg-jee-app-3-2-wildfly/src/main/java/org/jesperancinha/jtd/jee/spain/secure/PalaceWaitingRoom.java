package org.jesperancinha.jtd.jee.spain.secure;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Objects;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

// Caused by: org.jboss.weld.exceptions.DefinitionException:
// WELD-000082: Scope interface javax.enterprise.context.RequestScoped
// is not allowed on stateless session beans for
// class org.jesperancinha.jtd.jee.spain.secure.PalaceWaitingRoom.
// Only @Dependent is allowed.
// @Stateless
// @RequestScoped
// @Stateful
@Stateless
public class PalaceWaitingRoom implements Serializable {

    @EJB
    private ContextProvider contextProvider;

    @Resource
    private SessionContext context;

    public boolean isUserInRole(String roleName) {
        if (Objects.isNull(contextProvider)) {
            YELLOW.printGenericLn("The context provider session is null");
            YELLOW.printGenericLn("You probably call this from a JSP");
            YELLOW.printGenericLn("Try now using the REST service");
            return false;
        }
        try {
            ORANGE.printGenericLn("Is user %s in role %s? Answer: %s", contextProvider.getContext()
                    .getCallerPrincipal(), contextProvider.getContext()
                    .isCallerInRole(roleName));
        } catch (Exception exception) {
            RED.printGenericLn("This is expected! The AuthorizationManager is indeed not available -> %s", exception.getMessage());
        } finally {
            printRainbowTitleLn(contextProvider.getContext()
                    .getCallerPrincipal());
        }
        try {
            ORANGE.printGenericLn("Is user %s in role %s? Answer: %s", contextProvider.getContext()
                    .getCallerPrincipal(), context.isCallerInRole(roleName));
        } catch (Exception exception) {
            RED.printGenericLn("This is expected! The AuthorizationManager is indeed not available -> %s", exception.getMessage());
        } finally {
            printRainbowTitleLn(context.getCallerPrincipal());
        }
        return false;
    }

    public void setContext(SessionContext context) {
        this.context = context;
    }

    public ContextProvider getContextProvider() {
        return contextProvider;
    }

    @PostConstruct
    public void postConstruct() {
        BLUE.printGenericTitleLn("@PostConstruct");
        try {
            ORANGE.printGenericLn("Is user %s in role %s? Answer: %s", contextProvider.getContext()
                    .getCallerPrincipal(), contextProvider.getContext()
                    .isCallerInRole("roleName"));
        } catch (Exception exception) {
            RED.printGenericLn("This is expected! The AuthorizationManager is indeed not available -> %s", exception.getMessage());
        } finally {
            try {
                ORANGE.printGenericLn(contextProvider.getContext()
                        .getCallerPrincipal());
            } catch (Exception exception) {
                RED.printGenericLn("This is expected! We cannot access call the Principle in a Post Construct phase-> %s", exception.getMessage());

            }
        }
        try {
            ORANGE.printGenericLn("Is user %s in role %s? Answer: %s", contextProvider.getContext()
                    .getCallerPrincipal(), context.isCallerInRole("roleName"));
        } catch (Exception exception) {
            RED.printGenericLn("This is expected! The AuthorizationManager is indeed not available -> %s", exception.getMessage());
        } finally {
            try {
                ORANGE.printGenericLn(context.getCallerPrincipal());
            } catch (Exception exception) {
                RED.printGenericLn("This is expected! We cannot access call the Principle in a Post Construct phase-> %s", exception.getMessage());
            }
        }
    }

    @PreDestroy
    public void preDestroy() {
        BLUE.printGenericTitleLn("@PreDestroy");
        try {
            ORANGE.printGenericLn("Is user %s in role %s? Answer: %s", contextProvider.getContext()
                    .getCallerPrincipal(), contextProvider.getContext()
                    .isCallerInRole("roleName"));
        } catch (Exception exception) {
            RED.printGenericLn("This is expected! The AuthorizationManager is indeed not available -> %s", exception.getMessage());
        } finally {
            try {
                ORANGE.printGenericLn(contextProvider.getContext()
                        .getCallerPrincipal());
            } catch (Exception exception) {
                RED.printGenericLn("This is expected! We cannot access call the Principle in a Pre Destroy phase-> %s", exception.getMessage());
            }
        }
        try {
            ORANGE.printGenericLn("Is user %s in role %s? Answer: %s", contextProvider.getContext()
                    .getCallerPrincipal(), context.isCallerInRole("roleName"));
        } catch (Exception exception) {
            RED.printGenericLn("This is expected! The AuthorizationManager is indeed not available -> %s", exception.getMessage());
        } finally {
            try {
                ORANGE.printGenericLn(context.getCallerPrincipal());
            } catch (Exception exception) {
                RED.printGenericLn("This is expected! We cannot access call the Principle in a Pre Destroy phase-> %s", exception.getMessage());
            }
        }
    }

}