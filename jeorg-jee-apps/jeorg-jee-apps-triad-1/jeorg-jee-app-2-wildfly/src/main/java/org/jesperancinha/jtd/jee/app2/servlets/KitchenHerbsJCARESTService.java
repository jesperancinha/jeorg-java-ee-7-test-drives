package org.jesperancinha.jtd.jee.app2.servlets;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer8.Consolerizer.setupFastDefault;

@WebServlet("/herbs/connection")
public class KitchenHerbsJCARESTService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(mappedName = "java:/eis/KitchenHerbs")
    private Object kitchenHerbsConnectionFactory;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        setupFastDefault();
        String result = kitchenHerbsConnectionFactory.toString();

        PrintWriter out = response.getWriter();
        out.println(result);

        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}