/**
 * 
 */
package org.abc.loan.local;

import javax.xml.ws.Endpoint;

import org.abc.loan.service.LoanProcessingServiceImpl;

/**
 * @author vinays
 *
 */
public class Server {
	
	protected Server() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        LoanProcessingServiceImpl implementor = new LoanProcessingServiceImpl();
        String address = "http://localhost:9000/loanProcessingService";
        Endpoint.publish(address, implementor);
        // END SNIPPET: publish
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
