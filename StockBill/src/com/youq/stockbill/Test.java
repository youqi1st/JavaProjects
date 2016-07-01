package com.youq.stockbill;

import java.util.ArrayList;

public class Test {

	public static void main(String args[]) {
		String dir = "raw_data/";

//		FileLoader fl = new FileLoader();
//		fl.loadFilesFromPath(dir);
		
		RawDataParser rawDataParser = new RawDataParser(dir);
		ArrayList<TradeRecord> trl = rawDataParser.parseRawData();
		Utils.LOG("TEST", trl.toString());
//		Utils.printStringArrayList(trl);
//		Utils.printStringArrayList(rawDataParser.getUnparsedLines());
		
		
		ProfitAndLossCalculator pc = new ProfitAndLossCalculator(trl);
		pc.calculate();
	}

}
