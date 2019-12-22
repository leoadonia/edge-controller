package io.corestack.kubeedge.edge.api;

import io.corestack.kubeedge.edge.message.EdgeMessage;
import io.corestack.kubeedge.edge.socket.EdgeSocket;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/greeting")
public class DemoApi {

    @Autowired
    private EdgeSocket edgeSocket;

    @GetMapping
    public String hello() {
        Node node = new NodeBuilder()
                .withNewMetadata()
                .withName("aaa")
                .endMetadata()
                .build();

        EdgeMessage message = new EdgeMessage("node", node);
        edgeSocket.send(message);
        return "hello";
    }
}