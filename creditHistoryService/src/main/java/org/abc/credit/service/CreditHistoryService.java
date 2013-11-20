/**
 * 
 */
package org.abc.credit.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.constraints.NotNull;

import org.abc.credit.exception.CreditHistoryValidationException;
import org.abc.credit.model.Applicant;
import org.abc.credit.model.CreditBureauType;
import org.abc.credit.model.CreditHistory;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author vinays
 * Service interface for Credit History
 */
@WebService(targetNamespace="http://service.credit.abc.org/", name="creditHistoryService")
public interface CreditHistoryService {
	
	@WebMethod
	public CreditHistory getCreditHistory(	
			@WebParam(name = "applicant") @NotNull(message="Applicant can not be empty.") Applicant applicant,
   			@WebParam(name = "creditBureauType") @NotNull(message="Credit Bureau Type can not be empty.")  CreditBureauType creditBureauType
   			) throws CreditHistoryValidationException;
}
