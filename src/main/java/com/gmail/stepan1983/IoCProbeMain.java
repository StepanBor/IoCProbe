package com.gmail.stepan1983;

public class IoCProbeMain {

    public static void main(String[] args) {


        MessageProvider messageProvider=MessageProviderRenderFactory.getProvider();
        MessageRenderer messageRenderer=MessageProviderRenderFactory.getRenderer();

        messageRenderer.renderMessage();

    }
}
