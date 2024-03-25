package com.hexaware.main;

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
		System.out.println("Enter your choice :");
		System.out.println("1.Create Policy");
		System.out.println("2.Get Policy");
		System.out.println("3.Get All Policies");
		System.out.println("4.Update Policy");
		System.out.println("5.Delete Policy");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:{
			Policy policy = new Policy();
			ips.createPolicy(policy);
			break;
		}
		case 2:{
			System.out.println("Enter the policy ID:");
		    int policyId = sc.nextInt();
		    ips.getPolicy(policyId);
		    break;
		}
		case 3:{
			ips.getAllPolicies();
	    	        break;
		}
		case 4:{
			System.out.println("Enter the policy ID you want to update:");
                        int policyId = sc.nextInt();
                        Policy updatedPolicy = new Policy();
                        ips.updatePolicy(updatedPolicy);
                        break;
		}
		case 5:{
			System.out.println("Enter policy ID you want to delete:");
                        int policyId = sc.nextInt();
                        ips.deletePolicy(policyId);
                        break;
		}
		default: {
			System.out.println("Enter the right choice. ");
		}
		}
		System.out.println("Do you want to continue? Y or y");
		ch = sc.next();
	}while(ch.equals("Y") || ch.equals("y")); 
	   System.out.println("Thanks for using our system !!!");
	   System.exit(0);
}

}
