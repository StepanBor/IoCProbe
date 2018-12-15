package com.gmail.stepan1983.sprinngIoCProbe;

import com.gmail.stepan1983.MessageProvider;
import com.gmail.stepan1983.MessageRenderer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.lang.reflect.InvocationTargetException;

@Configuration
@PropertySource("classpath:app.properties")
public class ConfigIoC {

    @Value( "${provider}" )
    String configProvider;

    @Value( "${renderer}" )
    String configRenderer;

    @Bean
    public MessageProvider messageProvider()
            throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {

        return (MessageProvider) Class.forName(configProvider).newInstance();
    }

    @Bean
    public MessageRenderer messageRenderer(MessageProvider messageProvider)
            throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        return (MessageRenderer) Class.forName(configRenderer)
                .getConstructor(MessageProvider.class).newInstance(messageProvider);
    }

}
