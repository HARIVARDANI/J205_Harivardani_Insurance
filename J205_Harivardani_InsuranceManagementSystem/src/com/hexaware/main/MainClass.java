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
			ips.getAllPolici
