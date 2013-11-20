package org.abc.loan.service;

import static org.junit.Assert.*;

import org.abc.loan.exception.LoanProcessingValidationException;
import org.abc.loan.model.ApplicationStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml" })
public class LoanProcessingServiceTest {
	
	@Autowired
	private LoanProcessingService loanProcessingService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testGetApplicationStatus() throws Exception{
		
			ApplicationStatus applicationStatus = loanProcessingService.getApplicationStatus("1", "vinay", "Shiva");
			assertNotNull("Application Status is not null", applicationStatus);
			logger.info("Application Status is: "+ applicationStatus.toString());
			
	}

}
