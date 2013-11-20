package org.abc.credit.model;

/**
 * @author Vinays
 *
 */
public class CreditHistory {
	private Integer id;
	private String creditScore;
	private CreditBureauType creditBureau;
	private String requestedDate;
	private Integer applicantId;
	public CreditHistory (){};
	public CreditHistory(Integer id, String creditScore,
			CreditBureauType creditBureau, String requestedDate,
			Integer applicantId) {
		super();
		this.id = id;
		this.creditScore = creditScore;
		this.creditBureau = creditBureau;
		this.requestedDate = requestedDate;
		this.applicantId = applicantId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	public CreditBureauType getCreditBureau() {
		return creditBureau;
	}
	public void setCreditBureau(CreditBureauType creditBureau) {
		this.creditBureau = creditBureau;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	
	
	
}
