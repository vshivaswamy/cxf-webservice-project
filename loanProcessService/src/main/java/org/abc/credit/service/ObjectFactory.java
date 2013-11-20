
package org.abc.credit.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.abc.credit.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreditHistoryValidationException_QNAME = new QName("http://service.credit.abc.org/", "CreditHistoryValidationException");
    private final static QName _GetCreditHistoryResponse_QNAME = new QName("http://service.credit.abc.org/", "getCreditHistoryResponse");
    private final static QName _GetCreditHistory_QNAME = new QName("http://service.credit.abc.org/", "getCreditHistory");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.abc.credit.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Applicant }
     * 
     */
    public Applicant createApplicant() {
        return new Applicant();
    }

    /**
     * Create an instance of {@link GetCreditHistoryResponse }
     * 
     */
    public GetCreditHistoryResponse createGetCreditHistoryResponse() {
        return new GetCreditHistoryResponse();
    }

    /**
     * Create an instance of {@link GetCreditHistory }
     * 
     */
    public GetCreditHistory createGetCreditHistory() {
        return new GetCreditHistory();
    }

    /**
     * Create an instance of {@link CreditHistoryValidationException }
     * 
     */
    public CreditHistoryValidationException createCreditHistoryValidationException() {
        return new CreditHistoryValidationException();
    }

    /**
     * Create an instance of {@link CreditHistory }
     * 
     */
    public CreditHistory createCreditHistory() {
        return new CreditHistory();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditHistoryValidationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.credit.abc.org/", name = "CreditHistoryValidationException")
    public JAXBElement<CreditHistoryValidationException> createCreditHistoryValidationException(CreditHistoryValidationException value) {
        return new JAXBElement<CreditHistoryValidationException>(_CreditHistoryValidationException_QNAME, CreditHistoryValidationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.credit.abc.org/", name = "getCreditHistoryResponse")
    public JAXBElement<GetCreditHistoryResponse> createGetCreditHistoryResponse(GetCreditHistoryResponse value) {
        return new JAXBElement<GetCreditHistoryResponse>(_GetCreditHistoryResponse_QNAME, GetCreditHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.credit.abc.org/", name = "getCreditHistory")
    public JAXBElement<GetCreditHistory> createGetCreditHistory(GetCreditHistory value) {
        return new JAXBElement<GetCreditHistory>(_GetCreditHistory_QNAME, GetCreditHistory.class, null, value);
    }

}
