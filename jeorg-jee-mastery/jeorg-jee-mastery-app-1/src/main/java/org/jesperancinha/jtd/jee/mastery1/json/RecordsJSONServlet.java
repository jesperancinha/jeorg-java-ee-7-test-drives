package org.jesperancinha.jtd.jee.mastery1.json;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;
import org.jesperancinha.jtd.jee.mastery1.beans.RegisterCart;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@WebServlet("/json")
public class RecordsJSONServlet extends HttpServlet {

    @Inject
    private RegisterCart registerCart;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final JsonGenerator generator = Json.createGenerator(resp.getWriter());
        final List<Record> exampleRecords = registerCart.getExampleRecords();
        final JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        exampleRecords.stream().map(record ->
                Json.createObjectBuilder()
                        .add("name", record.getName())
                        .add("type", record.getType())
                        .add("year", record.getYear())
                        .add("artist", record.getArtist()).build())
                .forEach(arrayBuilder::add);
        final JsonArray jsonArray = arrayBuilder.build();
        generator.write(jsonArray);
        generator.close();
        YELLOW.printGenericLn(jsonArray);
    }
}
