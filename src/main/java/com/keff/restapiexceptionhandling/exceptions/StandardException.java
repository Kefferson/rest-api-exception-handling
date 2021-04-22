package com.keff.restapiexceptionhandling.exceptions;

import java.util.List;

public class StandardException {

    private final List<String> messages;

    public StandardException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
