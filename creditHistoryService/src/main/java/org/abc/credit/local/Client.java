package org.abc.credit.local;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.abc.credit.model.Applicant;
import org.abc.credit.model.CreditBureauType;
import org.abc.credit.model.CreditHistory;
import org.abc.credit.service.CreditHistoryService;

/**
 * @author Vinays
 * Client to run the CreditHistory service locally
 */
public final class Client {

    private static final QName SERVICE_NAME 
        = new QName("http://service.credit.abc.org/", "creditHistoryService");
    private static final QName PORT_NAME 
        = new QName("http://service.credit.abc.org/", "creditHistoryServicePort");

    private Client() {
    } 

    public static void main(String args[]) throws Exception {
        Service service = Service.create(SERVICE_NAME);
       
        String endpointAddress = "http://localhost:9000/creditHistoryService";
        // Add a port to the Service
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        CreditHistoryService creditHistoryService = service.getPort(CreditHistoryService.class);
        Applicant applicant = new Applicant();
        applicant.setFirstName("Vinay");
        applicant.setLastName("Shivaswamy");
        applicant.setId(new Integer(1));
        CreditHistory creditHistory = creditHistoryService.getCreditHistory(applicant, CreditBureauType.EQUIFAX);
        System.out.println("Credit Score recieved: "+creditHistory.getCreditScore());

    }

}
