package com.youq.stockbill;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Utils {

	public static void LOG(String Tag, String Msg){
		System.out.println(Tag + ":\t" + Msg);
	}
	
	public static String subStr(String str, int b, int e)
	{
		return str.substring(b, e).trim();
	}
	
	public static double subStrToDouble(String str, int b, int e)
	{
		String s = str.substring(b, e).trim();
		return Double.parseDouble(s);
	}
	
	public  static BufferedInputStream getResourceInputStream(String resourceName) {
		
		try {
				return new BufferedInputStream(new FileInputStream(resourceName));
			}
		catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	
		return null;
	}
	
}
