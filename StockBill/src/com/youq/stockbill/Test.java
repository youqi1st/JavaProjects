package com.youq.stockbill;

import java.util.ArrayList;

public class Test {

	public static void main(String args[]) {
		String dir = "raw_data/";

//		FileLoader fl = new FileLoader();
//		fl.loadFilesFromPath(dir);
		
		RawDataParser rawDataParser = new RawDataParser(dir);
		ArrayList<TradeRecord> trl = rawDataParser.parseRawData();
		
		double sum = 0;
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		for(TradeRecord tr : trl){
			if(tr.getTradingType() == TradeRecord.TRADING_TYPE_STOCK_BUY || tr.getTradingType() == TradeRecord.TRADING_TYPE_STOCK_SALE){
				sum1 += tr.getTradingAmount();
				sum2 -= tr.getHandlingCharge();
				sum3 -= tr.getStampTax();
			}
		}
		
		sum = sum1 + sum2 + sum3;
		Utils.LOG("TEST", "SUM = " + sum);
	}

}
