package org.jesperancinha.jtd.jee.mastery2.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.jtd.jee.mastery2.sockets.ListenerReceiver;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * ws://www.example.com/api/destination;
 */
@ClientEndpoint
public class WebSocketClient  extends Endpoint {

    /**
     * @param object
     * @param address
     * @throws URISyntaxException
     * @throws IOException
     * @throws DeploymentException
     */
    public void send(Object object, String address) throws URISyntaxException, IOException, DeploymentException {
        final URI uri = new URI(address);
        final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        final Session session = container.connectToServer(WebSocketClient.class, uri);
        final RemoteEndpoint.Async remote = session.getAsyncRemote();
        final ObjectMapper objectMapper = new ObjectMapper();
        remote.sendObject(objectMapper.writeValueAsString(object));
        session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Closing Session"));
    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {

    }
}
