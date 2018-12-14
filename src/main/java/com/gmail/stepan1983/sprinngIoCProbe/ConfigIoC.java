package com.gmail.stepan1983.sprinngIoCProbe;

import com.gmail.stepan1983.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigIoC {

    @Bean
    public MessageProvider messageProvider(String configClassName){
        return null;
    }

}
