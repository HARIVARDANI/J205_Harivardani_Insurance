package com.hexaware.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.hexaware.controller.PolicyServiceImpl;
import com.hexaware.dao.IPolicyService;
import com.hexaware.entity.Policy;

public class MainClass {
	
public static void main(String[] args) {
	
	IPolicyService ips = new PolicyServiceImpl();
	
	Scanner sc= new Scanner(System.in);
	String ch = null;
	do {
		try {
		System.out.println("Enter your choice :");
		System.out.println("1.Create Policy");
		System.out.println("2.Get Policy");
		System.out.println("3.Get All Policies");
		System.out.println("4.Update Policy");
		System.out.println("5.Delete Policy");
		int choice = sc.nextInt();
		switch(choice) {
		
		
		case 1:
			Policy policy = new Policy();
			System.out.println("Enter Policy Id:");
            policy.setPolicyId(sc.nextInt());
            System.out.println("Enter User Id:");
            policy.setUserId(sc.nextInt());
            System.out.println("Enter Client Id:");
            policy.setClientId(sc.nextInt());
            System.out.println("Enter Claim Id:");
            policy.setClaimId(sc.nextInt());
            System.out.println("Enter Policy Name:");
            policy.setPolicyName(sc.next());
            System.out.println("Enter Payment Id:");
            policy.setPaymentId(sc.nextInt());
            System.out.println("Enter Policy Premium:");
            policy.setPolicyPremium(sc.nextDouble());
			ips.createPolicy(policy);
			break;
		
		case 2:
			System.out.println("Enter the policy ID:");
		    int policyId = sc.nextInt();
		    ips.getPolicy(policyId);
		    break;
		
		case 3:
			ips.getAllPolicies();
	    	break;
		
		case 4:
			System.out.println("Enter the policy ID you want to update:");
            int policyId1 = sc.nextInt();
            Policy updatedPolicy = new Policy();
            ips.updatePolicy(updatedPolicy);
            break;
		
		case 5:
			System.out.println("Enter policy ID you want to delete:");
            int policyId2 = sc.nextInt();
            ips.deletePolicy(policyId2);
            break;
		
		default: 
			System.out.println("Enter the right choice. ");
		}
		
		System.out.println("Do you want to continue? Y or y");
		ch = sc.next();
	}catch (InputMismatchException e) {
		 System.out.println("Invalid input. Please enter a valid integer choice.");
         sc.next();
         ch = "Y";
	}
}while (ch.equals("Y") || ch.equals("y"));
    System.out.println("Thanks for using our system !!!");
    System.exit(0);
}
}
