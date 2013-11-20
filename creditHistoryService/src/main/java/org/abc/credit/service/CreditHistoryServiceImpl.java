/**
 * 
 */
package org.abc.credit.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.abc.credit.exception.CreditHistoryValidationException;
import org.abc.credit.model.Applicant;
import org.abc.credit.model.CreditBureauType;
import org.abc.credit.model.CreditHistory;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

/**
 * @author vinays
 * Service implementation for credit history.
 *
 */
@WebService
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
@OutInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingOutInterceptor")
@Validated
public class CreditHistoryServiceImpl implements CreditHistoryService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private static Map<Integer, String> scores = new HashMap<Integer, String>();
	
	@WebMethod
	public CreditHistory getCreditHistory(
			@WebParam(name = "applicant") Applicant applicant,
   			@WebParam(name = "creditBureauType") CreditBureauType creditBureauType
   			)throws CreditHistoryValidationException {
		
		log.info("Executing getCreditHistory method:");
		CreditHistory creditHistory = new CreditHistory();
		if(CreditBureauType.EQUIFAX.equals(creditBureauType)){
			creditHistory.setCreditBureau(creditBureauType);
			prepareCreditHistory(applicant, creditHistory);
		}
		return creditHistory;
	}
	
	private void prepareCreditHistory(Applicant applicant, CreditHistory creditHistory){
		loadCreditScores();
		creditHistory.setApplicantId(applicant.getId());
		if(scores.containsKey(creditHistory.getApplicantId())){
			creditHistory.setCreditScore((String)scores.get(creditHistory.getApplicantId()));
		}else
			creditHistory.setCreditScore("200");
		
		creditHistory.setRequestedDate(new Date().toString());
		
	}
	
	private void loadCreditScores(){
		scores.put(new Integer(1), "800");
		scores.put(new Integer(2), "750");
		scores.put(new Integer(3), "700");
		scores.put(new Integer(4), "650");
		scores.put(new Integer(5), "600");
	}

}
