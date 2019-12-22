package io.corestack.kubeedge.edge.socket;

import io.corestack.kubeedge.edge.message.EdgeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@Service
public class EdgeSocket {

    private final static Logger LOGGER = LoggerFactory.getLogger(EdgeSocket.class);

    private Session session;

    public EdgeSocket() throws IOException, DeploymentException {
        this.session = ContainerProvider.getWebSocketContainer().connectToServer(
                EdgeClient.class,
                URI.create("http://localhost:8080/node/edge")
        );
    }

    public void send(EdgeMessage edgeMessage) {
        this.session.getAsyncRemote().sendObject(edgeMessage, new SendHandler() {
            @Override
            public void onResult(SendResult sendResult) {
                LOGGER.info("Send result: {}, {}", sendResult.isOK(), sendResult.getException());
            }
        });
    }

    @ClientEndpoint (
            encoders = {MessageEncoder.class}
    )
    private static final class EdgeClient {

        @OnOpen
        public void onOpen(Session session) {
        }

    }

}
