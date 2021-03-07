package org.jesperancinha.jtd.jee.mastery1.websockets;

import javax.websocket.OnMessage;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@ServerEndpoint("/lyricsreceiver")
public class ServerLyricSender {

    @OnMessage
    public void textMessage(Session session, String msg) {
        RED.printGenericLn("Text message: " + msg);
    }

    @OnMessage
    public void binaryMessage(Session session, ByteBuffer msg) {
        byte[] array = new byte[msg.limit()];
        msg.get(array);
        final String receivedString = new String(array).replace("" + (char) 0, "");
        GREEN.printGenericLn("Binary message: " + msg.toString());
        GREEN.printGenericLn("Decoded Binary Message: " + receivedString);
    }

    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
        BLUE.printGenericLn("Pong message: " +
                msg.getApplicationData().toString());
    }
}