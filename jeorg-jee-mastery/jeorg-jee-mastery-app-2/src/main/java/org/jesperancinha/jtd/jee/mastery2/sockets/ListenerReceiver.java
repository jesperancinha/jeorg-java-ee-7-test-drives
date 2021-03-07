package org.jesperancinha.jtd.jee.mastery2.sockets;

import javax.websocket.OnMessage;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@ServerEndpoint(value = "/ariaschorus/lyrics",
        decoders = {LyricTextDecoder.class, LyricBinaryDecoder.class})
public class ListenerReceiver {

    @OnMessage
    public void receiveLyrics(Lyric lyric, Session session) {
        BLUE.printGenericTitleLn("With encoding this is the TEXT");
        BLUE.printGenericTitleLn(lyric);
        final RemoteEndpoint.Async asyncRemote = session.getAsyncRemote();
        asyncRemote.sendObject(lyric.toString());

    }

    @OnMessage
    public void receiveLyrics2(Lyric2 lyric, Session session) {
        BLUE.printGenericTitleLn("With encoding this is the BINARY");
        BLUE.printGenericTitleLn(lyric);
        final RemoteEndpoint.Async asyncRemote = session.getAsyncRemote();
        asyncRemote.sendObject(lyric.toString());
    }
}
