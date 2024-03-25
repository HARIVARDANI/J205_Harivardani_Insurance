package com.hexaware.entity;

public class Policy {
	
	private int policyId;
	private int userId;
    private int clientId;
    private int claimId;
    private String policyName;
    private int paymentId;
    private double policyPremium;
    
    public Policy() {
    	
    }

	public Policy(int policyId, int userId, int clientId, int claimId, String policyName, int paymentId,
			double policyPremium) {
		super();
		this.policyId = policyId;
		this.userId = userId;
		this.clientId = clientId;
		this.claimId = claimId;
		this.policyName = policyName;
		this.paymentId = paymentId;
		this.policyPremium = policyPremium;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", userId=" + userId + ", clientId=" + clientId + ", claimId=" + claimId
				+ ", policyName=" + policyName + ", paymentId=" + paymentId + ", policyPremium=" + policyPremium + "]";
	}

}