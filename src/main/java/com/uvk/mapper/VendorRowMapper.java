package com.uvk.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uvk.model.Vendor;

public class VendorRowMapper implements RowMapper<Vendor>{



	public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {

		Vendor vendor = new Vendor();

		
		vendor.setBankAccountNumber(rs.getString("BankAccountNumber"));
		vendor.setNextCheckNumber(rs.getString("NextCheckNumber"));

		return vendor;
	}
	
	
}
