package io.corestack.kubeedge.edge.message;

public class EdgeMessage {

    private String source;

    private Object data;

    public EdgeMessage() {

    }

    public EdgeMessage(String source, Object data) {
        this.source = source;
        this.data = data;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
