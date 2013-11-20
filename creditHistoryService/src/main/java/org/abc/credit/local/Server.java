/**
 * 
 */
package org.abc.credit.local;

import javax.xml.ws.Endpoint;

import org.abc.credit.service.CreditHistoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vinays
 * Server class to run the credit history service locally
 */
public class Server {
	Logger log = LoggerFactory.getLogger(this.getClass());
	protected Server() throws Exception {
      
        System.out.println("Starting Server");
        CreditHistoryServiceImpl implementor = new CreditHistoryServiceImpl();
        String address = "http://localhost:9000/creditHistoryService";
        Endpoint.publish(address, implementor);
        
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
