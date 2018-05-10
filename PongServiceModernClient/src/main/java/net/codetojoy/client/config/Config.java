package net.codetojoy.client.config;

import net.codetojoy.common.PongService;
import net.codetojoy.common.rmi.Constants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Configuration;

import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class Config {

    protected static final String BEAN_PONG_SERVICE = "pongService";
        
    @Bean
    public RmiRegistryFactoryBean myRegistry() {
        RmiRegistryFactoryBean result = new RmiRegistryFactoryBean();

        result.setHost(Constants.HOST);
        result.setPort(Constants.PORT);
        
        return result;
    }

    @Bean
    @Lazy
    public RmiProxyFactoryBean pongService() {
        RmiProxyFactoryBean pongService = new RmiProxyFactoryBean();

        pongService.setServiceUrl(Constants.PONG_SERVICE_URI);
        pongService.setServiceInterface(net.codetojoy.common.PongService.class);
        pongService.setRefreshStubOnConnectFailure(true);

        return pongService;
    }
}
