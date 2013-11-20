/**
 * 
 */
package org.abc.loan.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.abc.loan.exception.LoanProcessingValidationException;
import org.abc.loan.model.ApplicationStatus;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author rootl
 *
 */
@WebService(targetNamespace="http://service.loan.abc.org/", name="loanProcessingService")
public interface LoanProcessingService {
	
	@WebMethod
	public ApplicationStatus getApplicationStatus(	
			@WebParam(name = "applicationId") @NotBlank(message="Application Id can not be empty.") String applicationId,
   			@WebParam(name = "firstName") @NotBlank(message="First Name can not be empty.") @Length(min=2, max=30, message="First Name should be 2 to 30 characters long.") String firstName,
   			@WebParam(name = "lastName")  @NotBlank(message="Last Name can not be empty.") @Length(min=2, max=30, message="Last Name should be 2 to 30 characters long.") String lastName
   			) throws LoanProcessingValidationException;
}
