package net.codetojoy.client;

import net.codetojoy.client.config.PongConfiguration;
import net.codetojoy.common.PongService;
 
public class PongServiceModernClient {
    private final PongConfiguration pongConfiguration = new PongConfiguration();

    public PongService getPongService() {
        PongService pongService = null;

        try {
            pongService = pongConfiguration.getPongService(); 
        } catch (Exception ex) {
            System.err.println("TRACER caught exception : " + ex.getMessage());
        }

        return pongService;
    }
}
