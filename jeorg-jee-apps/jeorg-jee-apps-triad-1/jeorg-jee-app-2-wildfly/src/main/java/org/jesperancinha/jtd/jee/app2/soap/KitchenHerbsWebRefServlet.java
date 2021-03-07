package org.jesperancinha.jtd.jee.app2.soap;

import org.jesperancinha.jtd.jee.soap.KitchenHerbsServer;
import org.jesperancinha.jtd.jee.soap.KitchenHerbsServerImplService;

import javax.jws.HandlerChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/herbs/ref")
public class KitchenHerbsWebRefServlet extends HttpServlet {

    /**
     * Injecting the SEI (Service Endpoint Interface)
     */
    @WebServiceRef(KitchenHerbsServerImplService.class) // @WebServiceClient
    private KitchenHerbsServer kitchenHerbsMessenger;

    @WebServiceRef(wsdlLocation = "META-INF/kitchen-herbs.wsdl")
    private KitchenHerbsServerImplService kitchenHerbsServiceWsdl;

    @WebServiceRef
    public KitchenHerbsServerImplService helloMessengerServicePure;

    //    It is an error to combine this annotation with the @SOAPMessageHandlers annotation.
//    from: https://docs.oracle.com/javase/7/docs/api/javax/jws/HandlerChain.html
    @WebServiceRef
    @HandlerChain(file = "handler-chain.xml")
    private KitchenHerbsServerImplService kitchenHerbsMessengerHandlerChain;

    @WebServiceRef(wsdlLocation = "http://localhost:8080/jee-app-2-wildfly-ws-1.0-SNAPSHOT/kitchen-herbs?wsdl")
    private KitchenHerbsServerImplService KitchenHerbsServerImplService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>" + sayHello("world one") + "</p>");
            out.println("<p>" + sayHello2("world two") + "</p>");
            out.println("<p>" + sayHello3("world three") + "</p>");
            out.println("<p>" + sayHello4("world four") + "</p>");
            out.println("<p>" + sayHello5("world five") + "</p>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    private String sayHello(String name) {
        return KitchenHerbsServerImplService.getKitchenHerbsPort().sayHelloWorld(name);
    }

    private String sayHello2(String name) {
        return kitchenHerbsServiceWsdl.getKitchenHerbsPort().sayHelloWorld(name);
    }

    private String sayHello3(String name) {
        return helloMessengerServicePure.getKitchenHerbsPort().sayHelloWorld(name);
    }

    private String sayHello4(String name) {
        return kitchenHerbsMessengerHandlerChain.getKitchenHerbsPort().sayHelloWorld(name);
    }

    private String sayHello5(String name) {
        return kitchenHerbsMessenger.sayHelloWorld(name);
    }
}
