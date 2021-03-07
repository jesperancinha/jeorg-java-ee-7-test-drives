package org.jesperancinha.jtd.jee.portugal.rest.messages;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces("text/html")
public class KingdomMessageWriterProvider implements MessageBodyWriter<KingdomMessage> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
                               Annotation[] annotations, MediaType mediaType) {
        return type == KingdomMessage.class;
    }

    @Override
    public long getSize(KingdomMessage kingdomMessage, Class<?> aClass, Type type, Annotation[] annotations,
                        MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(KingdomMessage kingdomMessage, Class<?> aClass, Type type, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream)
            throws IOException, WebApplicationException {
        Writer writer = new PrintWriter(outputStream);
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<h1>Your Royal Highness King " + kingdomMessage.getTo() + "</h1>");
        writer.write("<h2>From: " + kingdomMessage.getFrom() + "</h2>");
        writer.write("<h2>Letter content </h2>");
        writer.write("<p>" + kingdomMessage.getText() + "</p>");
        writer.write("</body>");
        writer.write("</html>");
        writer.flush();
        writer.close();
    }

}