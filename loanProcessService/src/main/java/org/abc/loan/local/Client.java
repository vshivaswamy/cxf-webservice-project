package org.abc.loan.local;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.abc.loan.service.LoanProcessingService;
import org.abc.loan.service.LoanProcessingServiceImpl;

/**
 * @author vinays
 *
 */
public final class Client {

    private static final QName SERVICE_NAME 
        = new QName("http://service.loan.abc.org/", "loanProcessingService");
    private static final QName PORT_NAME 
        = new QName("http://service.loan.abc.org/", "loanProcessingServicePort");

    private Client() {
    } 

    public static void main(String args[]) throws Exception {
        Service service = Service.create(SERVICE_NAME);
       
        String endpointAddress = "http://localhost:9000/loanProcessingService";
        // If web service deployed on Tomcat deployment, endpoint should be changed to:
        // String endpointAddress = "http://localhost:8080/java_first_jaxws/services/hello_world";

        // Add a port to the Service
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        LoanProcessingService loanProcessing = service.getPort(LoanProcessingService.class);
        System.out.println(loanProcessing.getApplicationStatus("1", "Vinay", "Shivaswamy"));

        

    }

}
