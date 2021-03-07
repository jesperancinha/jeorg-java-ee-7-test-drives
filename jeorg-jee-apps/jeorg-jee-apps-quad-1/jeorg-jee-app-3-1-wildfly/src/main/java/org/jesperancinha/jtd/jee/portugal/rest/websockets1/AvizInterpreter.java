package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@ServerEndpoint("/aviz/interpreter")
public class AvizInterpreter {

    @OnOpen
    public void onOpen(Session session, EndpointConfig conf) throws IOException, EncodeException {
        BLUE.printGenericTitleLn("OnOpen from %s called!", this.getClass()
                .getCanonicalName());
    }

    @OnMessage
    public void textMessage(Session session, String msg) throws IOException {
        printRainbowTitleLn("Text: %s" + msg);
        session.getBasicRemote().sendText("The Interpreter is not available for normal messages");
    }

    @OnMessage
    public void binaryMessage(Session session, ByteBuffer msg) {
        printRainbowTitleLn("Binary: %s" + msg.toString());
    }

    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
        printRainbowTitleLn("Pong: %s" + msg.getApplicationData()
                .toString());
    }
}