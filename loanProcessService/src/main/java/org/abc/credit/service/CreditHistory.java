
package org.abc.credit.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditHistory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicantId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="creditBureau" type="{http://service.credit.abc.org/}creditBureauType" minOccurs="0"/>
 *         &lt;element name="creditScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="requestedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditHistory", propOrder = {
    "applicantId",
    "creditBureau",
    "creditScore",
    "id",
    "requestedDate"
})
public class CreditHistory {

    protected Integer applicantId;
    protected CreditBureauType creditBureau;
    protected String creditScore;
    protected Integer id;
    protected String requestedDate;

    /**
     * Gets the value of the applicantId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getApplicantId() {
        return applicantId;
    }

    /**
     * Sets the value of the applicantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setApplicantId(Integer value) {
        this.applicantId = value;
    }

    /**
     * Gets the value of the creditBureau property.
     * 
     * @return
     *     possible object is
     *     {@link CreditBureauType }
     *     
     */
    public CreditBureauType getCreditBureau() {
        return creditBureau;
    }

    /**
     * Sets the value of the creditBureau property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditBureauType }
     *     
     */
    public void setCreditBureau(CreditBureauType value) {
        this.creditBureau = value;
    }

    /**
     * Gets the value of the creditScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditScore() {
        return creditScore;
    }

    /**
     * Sets the value of the creditScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditScore(String value) {
        this.creditScore = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the requestedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedDate() {
        return requestedDate;
    }

    /**
     * Sets the value of the requestedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedDate(String value) {
        this.requestedDate = value;
    }

}
