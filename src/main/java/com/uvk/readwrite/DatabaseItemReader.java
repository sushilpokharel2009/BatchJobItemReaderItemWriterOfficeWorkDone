package com.uvk.readwrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.uvk.model.Vendor;

public class DatabaseItemReader implements ItemReader<Vendor> {

	private int nextVendorIndex;

	private List<Vendor> vendors = new ArrayList<Vendor>();

	DatabaseItemReader() {
		initialize();
	}

	private void initialize() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Class.forName("com.mysql.jdbc.Driver");
			
			
			
//			Db server: GHFGHFHGFYUTYUT07.DQA.cap.com
//			port:1433
//			user:abc
//			password:1234
//			table names: ABCDE, QRST
			//DatabaseName :MAS_SAC
			
			
			// protocol://ipaddress:portnumber/databasename
			String url = "jdbc:sqlserver:///GHFGHFHGFYUTYUT07.DQA.cap.com:1433;DatabaseName=MAAASSSS_SAAAARRRRC";
			//String url = "jdbc:mysql://localhost:3306/shubhaDB";
			
			//Connection conn = DriverManager.getConnection(url, "root", "");
			Connection conn = DriverManager.getConnection(url, "abc", "1234");
			
			Statement stmt = conn.createStatement();
			ResultSet rs2;
			
//			//TODO Get these table names from database or file
//			String[] tables = { "Test1", "Test2", "Test3", "Test4" };
//
//			for (int i = 0; i < tables.length; i++) {
//
//				rs = stmt.executeQuery("SELECT id, accountNumber, routingNumber from " + tables[i]);
//				while (rs.next()) {
//					Vendor vendor = new Vendor();
//					int id = rs.getInt("id");
//					String accountNumber = rs.getString("accountNumber");
//					String routingNumber = rs.getString("routingNumber");
//
//					vendor.setId(id);
//					vendor.setAccountNumber(accountNumber);
//					vendor.setRoutingNumber(routingNumber);
//					vendor.setTableName(tables[i]);
//
//					System.out.println("vendor : " + vendor);
//
//					vendors.add(vendor);
//				}
//
//			}
			
			 
			 rs2 = stmt.executeQuery("SELECT  BankAccountNumber, NextCheckNumber FROM GLOBAL_BANKK");
			 while ( rs2.next() ) { 
				 Vendor vendor = new Vendor(); 
				
				 String accountNumber = rs2.getString("BankAccountNumber");
			  String routingNumber = rs2.getString("NextCheckNumber");
			  
			  vendor.setBankAccountNumber(accountNumber); 
			  vendor.setNextCheckNumber(routingNumber);
			  
			  System.out.println("vendor : "+vendor);
			  
			  vendors.add(vendor); }
			 

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		nextVendorIndex = 0;
	}

	public Vendor read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		Vendor vendor = null;

		if (nextVendorIndex < vendors.size()) {
			vendor = vendors.get(nextVendorIndex);
			nextVendorIndex++;
		}

		return vendor;
	}

}
