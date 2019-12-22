package io.corestack.kubeedge.edge;

import io.corestack.kubeedge.edge.message.EdgeMessage;
import io.corestack.kubeedge.edge.socket.EdgeSocket;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeBuilder;
import io.quarkus.runtime.StartupEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.enterprise.event.Observes;

@Service
public class Bootstrap {

    @Autowired
    private EdgeSocket edgeSocket;

    public void start(@Observes StartupEvent event) {

        Node node = new NodeBuilder()
                .withNewMetadata()
                .withName("aaa")
                .endMetadata()
                .build();

        EdgeMessage message = new EdgeMessage("node", node);
        edgeSocket.send(message);
    }

}
