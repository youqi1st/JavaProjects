package com.youq.stockbill;

import java.util.ArrayList;

public class ProfitAndLossCalculator {

	private final static String LOG_TAG = "ProfitAndLossCalculator";
	private ArrayList<TradeRecord> mTrl = null;
	
	public ProfitAndLossCalculator(ArrayList<TradeRecord> trl){
		mTrl = trl;
	}
	
	public void calculate(){
		double Profit_And_Loss = 0;
		double Trading_Sum = 0;
		double Handling_Sum = 0;
		double Stamp_Sum = 0;
		double Dividen_Earning_Stock_Sum = 0;
		double Dividen_Tax_Sum = 0;
		double Dividen_Earning_TTL_Sum = 0;
		double Interest_Earning_Sum = 0;
		
		
		for(TradeRecord tr : mTrl){
			if(tr.getTradingType() == TradeRecord.TRADING_TYPE_STOCK_BUY || tr.getTradingType() == TradeRecord.TRADING_TYPE_STOCK_SALE){
				Trading_Sum += tr.getTradingAmount();
				Handling_Sum -= tr.getHandlingCharge();
				Stamp_Sum -= tr.getStampTax();
			}
			
			if(tr.getTradingType() == TradeRecord.TRADING_TYPE_DIVIDEND_EARNING_STOCK){
				Dividen_Earning_Stock_Sum += tr.getTradingAmount();
			}
			if(tr.getTradingType() == TradeRecord.TRADING_TYPE_DIVIDEND_TAX){
				Dividen_Tax_Sum += tr.getTradingAmount();
			}
			if(tr.getTradingType() == TradeRecord.TRADING_TYPE_DIVIDEND_EARNING_TTL){
				Dividen_Earning_TTL_Sum += tr.getTradingAmount();
			}
			if(tr.getTradingType() == TradeRecord.TRADING_TYPE_INTEREST_EARNING){
				Interest_Earning_Sum += tr.getTradingAmount();
			}
		}
		
		
		Profit_And_Loss = Trading_Sum + Handling_Sum + Stamp_Sum +
				Dividen_Earning_Stock_Sum + Dividen_Tax_Sum + Dividen_Earning_TTL_Sum + Dividen_Earning_TTL_Sum + Interest_Earning_Sum;
		Utils.LOG(LOG_TAG, "Dividen_Earning_Stock_Sum = " + Dividen_Earning_Stock_Sum);
		Utils.LOG(LOG_TAG, "Dividen_Tax_Sum = " + Dividen_Tax_Sum);
		Utils.LOG(LOG_TAG, "Dividen_Earning_TTL_Sum = " + Dividen_Earning_TTL_Sum);
		Utils.LOG(LOG_TAG, "Interest_Earning_Sum = " + Interest_Earning_Sum);
		Utils.LOG(LOG_TAG, "Tolal Profit_And_Loss = " + Profit_And_Loss);
	}
}
