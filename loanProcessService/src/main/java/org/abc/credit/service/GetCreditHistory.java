
package org.abc.credit.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCreditHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCreditHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicant" type="{http://service.credit.abc.org/}applicant" minOccurs="0"/>
 *         &lt;element name="creditBureauType" type="{http://service.credit.abc.org/}creditBureauType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCreditHistory", propOrder = {
    "applicant",
    "creditBureauType"
})
public class GetCreditHistory {

    protected Applicant applicant;
    protected CreditBureauType creditBureauType;

    /**
     * Gets the value of the applicant property.
     * 
     * @return
     *     possible object is
     *     {@link Applicant }
     *     
     */
    public Applicant getApplicant() {
        return applicant;
    }

    /**
     * Sets the value of the applicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Applicant }
     *     
     */
    public void setApplicant(Applicant value) {
        this.applicant = value;
    }

    /**
     * Gets the value of the creditBureauType property.
     * 
     * @return
     *     possible object is
     *     {@link CreditBureauType }
     *     
     */
    public CreditBureauType getCreditBureauType() {
        return creditBureauType;
    }

    /**
     * Sets the value of the creditBureauType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditBureauType }
     *     
     */
    public void setCreditBureauType(CreditBureauType value) {
        this.creditBureauType = value;
    }

}
