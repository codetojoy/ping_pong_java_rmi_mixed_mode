package net.codetojoy.server; 

import net.codetojoy.client.PingServiceClient;
import net.codetojoy.common.*;
import net.codetojoy.common.rmi.*;
import net.codetojoy.server.config.PongConfiguration;

public class PongServiceImpl implements PongService {
    private static final long serialVersionUID = 1L;

    private final PongConfiguration pongConfiguration = new PongConfiguration();

    @Override
    public long healthCheck() {
        return System.currentTimeMillis();
    } 

    @Override
    public Ball pong(Ball ball) {
        Ball result = ball;

        if (! ball.isMaxedOut()) {
            String message = "     #: " + (ball.getNumHits() + 1) + " PONG";
            System.out.println("TRACER " + message);

            Ball newBall = ball.hit(message);
            
            try {
                System.out.println("TRACER Pong does not have Ping in this example");
                System.out.println("TRACER halting sequence. numHits: " + ball.getNumHits());
                System.out.println("TRACER ball: " + ball.toString());
                PingService pingService = new PingServiceClient().getPingService();
                result = pingService.ping(newBall);
            } catch (Exception ex) {
                System.err.println("TRACER caught exception on ping service, so sequence will end here");
            }
        } else {
            System.out.println("TRACER halting sequence. numHits: " + ball.getNumHits());
            System.out.println("TRACER ball: " + ball.toString());
        }
        
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\n\nTRACER: PongService starting up...");

        PongServiceImpl pongServiceImpl = new PongServiceImpl();
        // this is the server which will listen ... so `main` will not exit
        pongServiceImpl.pongConfiguration.getPongServiceExporter();

        System.out.println("\n\nTRACER: PongService ready !");
    }
}
