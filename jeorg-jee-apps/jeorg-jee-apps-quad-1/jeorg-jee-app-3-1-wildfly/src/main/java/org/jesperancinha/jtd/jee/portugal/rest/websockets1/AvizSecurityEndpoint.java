package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@ServerEndpoint(value = "/aviz/security",
        encoders = {AvizEncoder.class},
        decoders = {AvizDecoder.class})
public class AvizSecurityEndpoint {

    @OnOpen
    public void onOpen(Session session, EndpointConfig conf) {
        BLUE.printGenericTitleLn("");
    }

    @OnMessage
    public void onMessage(Session session, String decodedMessage) throws IOException, EncodeException {
        ORANGE.printGenericLn(decodedMessage);
        GREEN.printGenericLn(decodedMessage);
        final AvizEncodedMessage data = new AvizEncodedMessage();
        data.setEncodedMessage(decodedMessage);
        session.getBasicRemote().sendObject(data);
    }

}
