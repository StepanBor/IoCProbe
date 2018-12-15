package com.gmail.stepan1983;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCProbeMain {

    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext("com.gmail.stepan1983");



//        MessageProvider messageProvider=MessageProviderRenderFactory.getProvider();
//        MessageRenderer messageRenderer=MessageProviderRenderFactory.getRenderer();
        MessageRenderer messageRenderer=(MessageRenderer) context.getBean("messageRenderer");

        messageRenderer.renderMessage();

    }
}
