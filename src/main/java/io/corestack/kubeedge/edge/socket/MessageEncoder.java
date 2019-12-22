package io.corestack.kubeedge.edge.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text {

    private ObjectMapper objectMapper;

    @Override
    public String encode(Object o) throws EncodeException {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new EncodeException(o, e.getMessage(), e);
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void destroy() {

    }
}
