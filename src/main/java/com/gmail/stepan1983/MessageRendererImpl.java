package com.gmail.stepan1983;

public class MessageRendererImpl implements MessageRenderer {

    private MessageProvider messageProvider;

    public MessageRendererImpl(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public void renderMessage() {

        System.out.println(messageProvider.getMassage());

    }
}
