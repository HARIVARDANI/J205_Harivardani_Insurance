package com.hexaware.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Policy;
import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.util.DBUtil;

public class PolicyDao {
	
	Connection con;
	PreparedStatement ps;
	java.sql.Statement stmt;
	ResultSet rs;
	
	public boolean createPolicy(Policy pol) {
        try {
            con = DBUtil.getDBConn(); // Get database connection
            PreparedStatement ps = con.prepareStatement("INSERT INTO Policy (policyId,userId, clientId, claimId,policyName, paymentId, policyPremium) " 
            + " VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, pol.getPolicyId());
            ps.setInt(2, pol.getUserId());
            ps.setInt(3, pol.getClientId());
            ps.setInt(4, pol.getClaimId());
            ps.setString(5, pol.getPolicyName());
            ps.setInt(6, pol.getPaymentId());
            ps.setDouble(7,pol.getPolicyPremium());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Policy inserted successfully.");
                return true;
            } else {
                System.out.println("Failed to insert policy.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public Policy getPolicy(int policyId) throws PolicyNotFoundException{
		Policy policy = null;
		try (Connection con = DBUtil.getDBConn();
		         PreparedStatement ps = con.prepareStatement("SELECT * FROM Policy WHERE policyId = ?")) {
		        ps.setInt(1, policyId);
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                System.out.println("Policy Id: " + rs.getInt("policyId"));
		                System.out.println("User Id: " + rs.getInt("userId"));
		                System.out.println("Client Id: " + rs.getInt("clientId"));
		                System.out.println("Claim Id: " + rs.getInt("claimId"));
		                System.out.println("Policy Name: " + rs.getString("policyName"));
		                System.out.println("Payment Id: " + rs.getInt("paymentId"));
		                System.out.println("Policy Premium: " + rs.getDouble("policyPremium"));               
		            } else {
		                throw new PolicyNotFoundException("Policy with ID " + policyId + " not found");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	return policy;
}


   public List<Policy> showPolicies() {
	List<Policy> policies = new ArrayList<>();
	
	try {
		con = DBUtil.getDBConn();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Policy");
		while(rs.next()) {
			Policy policy = new Policy();
			    policy.setPolicyId(rs.getInt(1));
	            policy.setUserId(rs.getInt(2));
	            policy.setClientId(rs.getInt(3));
	            policy.setClaimId(rs.getInt(4));
	            policy.setPolicyName(rs.getString(5));
	            policy.setPaymentId(rs.getInt(6));
	            policy.setPolicyPremium(rs.getDouble(7));
	         policies.add(policy);   
		}
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	return policies;
}
   public boolean updatePolicy(Policy policy) {
       boolean updated = false;
       try (Connection con = DBUtil.getDBConn();
            PreparedStatement ps = con.prepareStatement("UPDATE Policy SET userId=?, clientId=?, claimId=?, policyName=?, paymentId=?, policyPremium=? WHERE policyId=?")) {
           
           ps.setInt(1, policy.getUserId());
           ps.setInt(2, policy.getClientId());
           ps.setInt(3, policy.getClaimId());
           ps.setString(4, policy.getPolicyName());
           ps.setInt(5, policy.getPaymentId());
           ps.setDouble(6, policy.getPolicyPremium());
           ps.setInt(7, policy.getPolicyId());          
           int rowsUpdated = ps.executeUpdate();
           updated = rowsUpdated > 0;
           
          System.out.println(rowsUpdated + " rows updated.");
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return updated;
   }
   
   public boolean deletePolicy(int policyId) {
       boolean deleted = false;
       try (Connection con = DBUtil.getDBConn();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Policy WHERE policyId = ?")) {
           
           ps.setInt(1, policyId);
           
           int rowsDeleted = ps.executeUpdate();
           deleted = rowsDeleted > 0;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return deleted;
   }
}





