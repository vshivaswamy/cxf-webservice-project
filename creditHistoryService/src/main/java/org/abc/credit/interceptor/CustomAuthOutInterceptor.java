/**
 * 
 */
package org.abc.credit.interceptor;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author vinays
 * Custom Auth out Interceptor
 */
public class CustomAuthOutInterceptor extends AbstractSoapInterceptor {
	Logger log = LoggerFactory.getLogger(this.getClass());
	

	public CustomAuthOutInterceptor() {
		super(Phase.WRITE);
		addAfter(SoapPreProtocolOutInterceptor.class.getName());
	}

	public void handleMessage(SoapMessage message) throws Fault {
		log.info("CustomAuthOutInterceptor handleMessage invoked");
		DocumentBuilder builder = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = builder.newDocument();
		Element elementCredentials = doc.createElement("credentials");
		Element elementKey = doc.createElement("key");
		elementKey.setTextContent("12345");
		
		elementCredentials.appendChild(elementKey);
		
		// Create Header object
		QName qnameCredentials = new QName("credentials");
		Header header = new Header(qnameCredentials, elementCredentials);
		message.getHeaders().add(header);

	}

}
