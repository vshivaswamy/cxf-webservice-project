package org.abc.credit.service;

import static org.junit.Assert.assertNotNull;

import org.abc.credit.model.Applicant;
import org.abc.credit.model.CreditBureauType;
import org.abc.credit.model.CreditHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author vinays
 * Credt History service test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml" })
public class CreditHistoryServiceTest {
	
	@Autowired
	private CreditHistoryService creditHistoryService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testGetCreditistory() throws Exception{
		Applicant applicant = new Applicant();
        applicant.setFirstName("Vinay");
        applicant.setLastName("Shivaswamy");
        applicant.setId(new Integer(1));
		CreditHistory creditHistory = creditHistoryService.getCreditHistory(applicant, CreditBureauType.EQUIFAX);
			assertNotNull("Credit History recieved is not null", creditHistory);
			logger.info("Credit History recieved and score is: "+ creditHistory.getCreditScore());
			
	}

}
