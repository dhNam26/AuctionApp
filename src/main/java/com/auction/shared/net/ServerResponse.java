package com.auction.shared.net;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String requestId;
    private boolean success;
    private boolean event;
    private MessageType type;
    private String message;
    private Object payload;

    public ServerResponse() {}

    public ServerResponse(String requestId, boolean success, boolean event, MessageType type, String message, Object payload) {
        this.requestId = requestId;
        this.success = success;
        this.event = event;
        this.type = type;
        this.message = message;
        this.payload = payload;
    }

    public static ServerResponse success(String requestId, MessageType type, Object payload) {
        return new ServerResponse(requestId, true, false, type, "OK", payload);
    }

    public static ServerResponse failure(String requestId, MessageType type, String message) {
        return new ServerResponse(requestId, false, false, type, message, null);
    }

    public static ServerResponse event(MessageType eventType, String message, Object payload) {
        return new ServerResponse(null, true, true, eventType, message, payload);
    }

    public String getRequestId() {
        return requestId;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isEvent() {
        return event;
    }

    public MessageType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
