/**
 * 
 */
package org.abc.credit.interceptor;

import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vinays
 * Custom Auth Interceptor to validate the auth key
 */
public class CustomAuthInInterceptor extends AbstractSoapInterceptor  {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	public CustomAuthInInterceptor() {
		super(Phase.PRE_INVOKE);
    }

	public void handleMessage(SoapMessage message) throws Fault {
		log.info("Executing CustomAuthInterceptor");
		if (message.getVersion() instanceof Soap11) {
            Map<String, List<String>> headers = CastUtils.cast((Map)message.get(Message.PROTOCOL_HEADERS));
            if (headers != null) {
                List<String> sa = headers.get("key");
                if(sa == null)
                	throw new Fault(new Exception("The auth key is missing."));
                if (sa != null && sa.size() > 0) {
                    String key = sa.get(0);
                    if(!key.equals("12345")){
                    	throw new Fault(
                                new Exception("The auth key is invalid."));
                    }
                 }
            }
        }
	}
}
