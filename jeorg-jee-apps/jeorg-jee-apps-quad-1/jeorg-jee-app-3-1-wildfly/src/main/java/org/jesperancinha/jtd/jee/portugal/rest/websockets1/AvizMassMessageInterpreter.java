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

@ServerEndpoint("/aviz/interpreter/mass")
public class AvizMassMessageInterpreter {

    @OnOpen
    public void onOpen(Session session, EndpointConfig conf) throws IOException, EncodeException {
        BLUE.printGenericTitleLn("OnOpen from %s called!", this.getClass()
                .getCanonicalName());
    }

    @OnMessage
    public void textMessage(Session session, String msg, boolean last) throws IOException {
        printRainbowTitleLn("Text: %s", msg);
        printRainbowTitleLn("Last: %s", last);
        session.getBasicRemote()
                .sendText("The Interpreter is not available for normal messages - ", false);
        session.getBasicRemote().sendText("This is false - ", false);
        session.getBasicRemote().sendText("And this is true", true);
    }

    @OnMessage
    public void binaryMessage(Session session, ByteBuffer msg) throws IOException {
        printRainbowTitleLn("Binary: %s", msg.toString());
        session.getBasicRemote().sendBinary(msg);
    }

    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
        printRainbowTitleLn("Pong: %s" + msg.getApplicationData()
                .toString());
    }
}