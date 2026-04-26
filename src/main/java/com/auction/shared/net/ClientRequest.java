package com.auction.shared.net;

import com.auction.shared.dto.UserSession;

import java.io.Serializable;
import java.util.UUID;

public class ClientRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String requestId;
    private MessageType type;
    private Object payload;
    private UserSession session;

    public ClientRequest() {
        this.requestId = UUID.randomUUID().toString();
    }

    public ClientRequest(MessageType type, Object payload) {
        this.requestId = UUID.randomUUID().toString();
        this.type = type;
        this.payload = payload;
    }

    public ClientRequest(MessageType type, Object payload, UserSession session) {
        this.requestId = UUID.randomUUID().toString();
        this.type = type;
        this.payload = payload;
        this.session = session;
    }

    public String getRequestId() {
        return requestId;
    }

    public MessageType getType() {
        return type;
    }

    public Object getPayload() {
        return payload;
    }

    public UserSession getSession() {
        return session;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }
}
