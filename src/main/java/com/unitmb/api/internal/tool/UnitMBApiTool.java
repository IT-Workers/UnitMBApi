package com.unitmb.api.internal.tool;

import java.math.BigInteger;
import java.security.MessageDigest;

public class UnitMBApiTool {

	public static class Security{
		
		public static String md5(String value) {
			try {
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        md.update(value.getBytes());
		        return new BigInteger(1, md.digest()).toString(16);
		    } catch (Exception e) {
		    	e.printStackTrace();
		    	return value;
		    }
		}
	}
}
