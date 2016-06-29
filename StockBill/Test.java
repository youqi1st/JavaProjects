package com.youq.stockbill;

public class Test {

	public static void main(String args[]) {
		String dir = "raw_data/";

		FileLoader fl = new FileLoader();
		fl.loadFromPath(dir);
	}
}
