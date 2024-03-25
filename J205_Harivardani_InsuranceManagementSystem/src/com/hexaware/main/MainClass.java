package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.IPolicyService;
import com.hexaware.dao.PolicyDao;
import com.hexaware.entity.Policy;
import com.hexaware.exception.PolicyNotFoundException;

public class PolicyServiceImpl implements IPolicyService {
	
	Policy pol;
	List<Policy> polist = new ArrayList<Policy>();
	PolicyDao dao = new PolicyDao();
	Scanner sc = new Scanner(System.in);

	@Override
	public boolean createPolicy(Policy policy) {
		
		pol = new Policy();
		
		System.out.println("Enter Policy Id :");
		int policyId = sc.nextInt();
		pol.setPolicyId(policyId);
		
		System.out.println("Enter User Id :");
		int userId = sc.nextInt();
		pol.setUserId(userId);
		
		System.out.println("Enter Client Id :");
		int clientId = sc.nextInt();
		pol.setClientId(clientId);

		System.out.println("Enter Claim Id :");
		int claimId = sc.nextInt();
		pol.setClaimId(claimId);
		
		System.out.println("Enter Policy Name :");
		String policyName = sc.next();
		pol.setPolicyName(policyName);
		
		System.out.println("Enter Payment Id :");
		int paymentId = sc.nextInt();
		pol.setPaymentId(paymentId);
		
		System.out.println("Enter Policy Premium :");
		double policyPremium = sc.nextDouble();
		pol.setPolicyPremium(policyPremium);
		
		dao.createPolicy(pol);
        System.out.println("Policy created successfully.");
		return false;
		
	}

	@Override
	public Policy getPolicy(int policyId) {
		try {
		      return dao.getPolicy(policyId);
		    } catch ( PolicyNotFoundException e) {
		        System.out.println(e.getMessage());
		        return null;
		    }
		}

	@Override
	public List<Policy> getAllPolicies() {
		polist = dao.showPolicies();
	    for (Policy policy : polist) {
	        System.out.println(policy); 
	    }
	    return polist;
		
	}

	@Override
	public boolean updatePolicy(Policy policy) {
		try {
			
			System.out.println("Enter Policy ID to update:");
            int policyId = sc.nextInt();
            
            System.out.println("Enter User ID to update:");
            int userId = sc.nextInt();
            
            System.out.println("Enter Client ID to update:");
            int clientId = sc.nextInt();
            
            System.out.println("Enter claim ID to update:");
            int claimId = sc.nextInt();
            
            System.out.println("Enter Policy name to update:");
            String policyName = sc.next();
            
            System.out.println("Enter Payment ID to update:");
            int paymentId = sc.nextInt();
            
            System.out.println("Enter policy premium to update:");
            double policyPremium = sc.nextDouble();
            
            Policy updatedPolicy = new Policy(userId, clientId, claimId, policyId, policyName, paymentId, policyPremium);
            return dao.updatePolicy(updatedPolicy);
		}catch(NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid number.");
            return false;
		}
	}

	@Override
	public boolean deletePolicy(int policyId) {
		
		try {
            System.out.println("Enter Policy ID to delete:");
            int policyId1 = sc.nextInt();            
            return dao.deletePolicy(policyId1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return false;
		
			}
	}
}
