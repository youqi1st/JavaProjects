package com.youq.stockbill;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Utils {

	public static void LOG(String Tag, String Msg){
		System.out.println(Tag + ":\t" + Msg);
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
