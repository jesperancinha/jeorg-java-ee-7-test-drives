package org.jesperancinha.jtd.jee.mastery2.sockets;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.OnMessage;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;
import java.nio.ByteBuffer;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@ServerEndpoint(value = "/ariaschorus/noencoding/lyrics")
public class ListenerNoCodingReceiver {

    @OnMessage
    public void receiveLyrics(String text, Session session) {
        BLUE.printGenericTitleLn("Without encoding this is the TEXT");
        BLUE.printGenericTitleLn(text);
        JsonObject jsonObject = Json
                .createReader(new StringReader(text)).readObject();
        Lyric lyric = new Lyric();
        lyric.setSong(jsonObject.getString("song"));
        lyric.setArtist(jsonObject.getString("artist"));
        lyric.setLyricExtract(jsonObject.getString("lyricExtract"));
        final RemoteEndpoint.Async asyncRemote = session.getAsyncRemote();
        asyncRemote.sendObject(text);
    }

    @OnMessage
    public void receiveLyrics2(ByteBuffer bytes, Session session) {
        BLUE.printGenericTitleLn("Without encoding this is the BINARY");
        byte[] array = new byte[bytes.limit()];
        bytes.get(array);
        final String receivedString = new String(array).replace("" + (char) 0, "");
        JsonObject jsonObject = Json
                .createReader(new StringReader(receivedString)).readObject();
        Lyric2 lyric2 = new Lyric2();
        lyric2.setSong(jsonObject.getString("song"));
        lyric2.setArtist(jsonObject.getString("artist"));
        lyric2.setLyricExtract(jsonObject.getString("lyricExtract"));
        BLUE.printGenericTitleLn(lyric2);
        final RemoteEndpoint.Async asyncRemote = session.getAsyncRemote();
        asyncRemote.sendObject(receivedString);
    }
}
