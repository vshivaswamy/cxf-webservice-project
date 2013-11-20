/**
 * 
 */
package org.abc.loan.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.abc.credit.service.Applicant;
import org.abc.credit.service.CreditBureauType;
import org.abc.credit.service.CreditHistory;
import org.abc.credit.service.CreditHistoryService;
import org.abc.credit.service.CreditHistoryValidationException_Exception;
import org.abc.loan.exception.LoanProcessingValidationException;
import org.abc.loan.model.ApplicationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

/**
 * @author root
 *
 */
@WebService//(//targetNamespace="http://service.loan.abc.org/", name="LoanProcessingService",
		//endpointInterface="org.abc.loan.service.LoanProcessingService", serviceName="LoanProcessingService")
@Validated
public class LoanProcessingServiceImpl implements LoanProcessingService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private CreditHistoryService creditHistoryService;
	
	public CreditHistoryService getCreditHistoryService() {
		return creditHistoryService;
	}

	public void setCreditHistoryService(CreditHistoryService creditHistoryService) {
		this.creditHistoryService = creditHistoryService;
	}

	@WebMethod
	public ApplicationStatus getApplicationStatus(
			@WebParam(name = "applicationId") String applicationId,
			@WebParam(name = "firstName") String firstName,
			@WebParam(name = "lastName") String lastName)
			throws LoanProcessingValidationException {
		
		log.info("Executing getApplicationStatus method:");
		CreditHistory creditHistory = null;
		ApplicationStatus status = null;
		Applicant applicant = new Applicant();
		applicant.setId(Integer.valueOf(applicationId));
		applicant.setFirstName(firstName);
		applicant.setLastName(lastName);
		try {
			creditHistory = creditHistoryService.getCreditHistory(applicant, CreditBureauType.EQUIFAX);
		} catch (CreditHistoryValidationException_Exception e) {
			e.printStackTrace();
			throw new LoanProcessingValidationException("Credit History Not available for the applicant.");
		}
		
		if(creditHistory != null){
			int score = Integer.parseInt(creditHistory.getCreditScore());
			if(score >= 700)
				status = ApplicationStatus.APPROVED;
			else if(score >= 600 && score < 700)
				status = ApplicationStatus.PENDING;
			else 
				status = ApplicationStatus.DECLINED;
		}
		
		return status;
	}

}
