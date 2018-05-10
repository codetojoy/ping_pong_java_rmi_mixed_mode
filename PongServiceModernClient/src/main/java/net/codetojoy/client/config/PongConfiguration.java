package net.codetojoy.client.config;

import net.codetojoy.common.PongService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class PongConfiguration {
    private final AnnotationConfigApplicationContext context;
    
    public PongConfiguration() {
        context = new AnnotationConfigApplicationContext(Config.class);        
    }

    // client
    public PongService getPongService() throws Exception {
        return context.getBean(Config.BEAN_PONG_SERVICE, PongService.class); 
    }
}
