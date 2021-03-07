package org.jesperancinha.jtd.jee.portugal.rest.messages;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes("application/text")
public class KingdomMessageReaderProvider implements MessageBodyReader<KingdomMessage> {
    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return type == KingdomMessage.class;
    }

    @Override
    public KingdomMessage readFrom(Class<KingdomMessage> aClass, Type type, Annotation[] annotations,
                                   MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream)
            throws IOException, WebApplicationException {
        try (final var bir = new BufferedInputStream(inputStream)) {
            final byte[] bytes = bir.readAllBytes();
            final String fullMessage = new String(bytes);
            final String[] split = fullMessage.split("\\*\\*\\* ");
            final var kingdomMessage = new KingdomMessage();
            kingdomMessage.setText(split[1]);
            kingdomMessage.setTo(split[2]);
            kingdomMessage.setFrom(split[3]);
            return kingdomMessage;
        }
    }
}
