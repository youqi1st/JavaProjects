package com.youq.stockbill;

public class TradeRecord {

	private int mTradingType;			//unique trading type
	private static final int TRADING_TYPE_STOCK_BUY = 1;		//证券买入
	private static final int TRADING_TYPE_STOCK_SALE = 2;		//证券卖出
	private static final int TRADING_TYPE_BANK_WITHDRAW = 3;	//银行转取
	private static final int TRADING_TYPE_BANK_DEPOSIT = 4;		//银行转存 
	private static final int TRADING_TYPE_MARGIN_BUY_TTL = 5;	//保证金产品申购天添利
	private static final int TRADING_TYPE_MARGIN_SALE_TTL = 6;	//保证金产品赎回天添利	 
	
	private String mTradingDate;		//发生日期   
	private String mStockHolderCode;		//股东代码
	private String mBankCode;			//银行代码
	private String mDigestMsg;			//摘                   要
	private double mTradingNum;			//成交数 成交均价    
	private double mHandlingCharge;		//手续费
	private double mStampTax;			//印花税等
	private double mTradingAmount;		//变动金额  
	private double mRemainingBalance;	//资金余额
	
	public TradeRecord(int tradingType){
		mTradingType = tradingType;
		
	}
	
	public TradeRecord(
			int tradingType,
			
			String tradingDate,
			String stockHolderCode,
			String bankCode,
			String digestMsg,
			double tradingNum,
			double handlingCharge,
			double stampTax,
			double tradingAmount,
			double rememainingBalance){
		
		mTradingType = tradingType;
		
		mTradingDate = tradingDate;
		mStockHolderCode = stockHolderCode;
		mBankCode = bankCode;
		mDigestMsg = digestMsg;
		mTradingNum = tradingNum;
		mHandlingCharge = handlingCharge;
		mStampTax = stampTax;
		mTradingAmount = tradingAmount;
		mRemainingBalance = rememainingBalance;
		
	}
	
	public double getHandlingCharge(){
		return mHandlingCharge;
	}
	public double getStampTax(){
		return mStampTax;
	}
	
	public double getTradingAmount(){
		return mTradingAmount;
	}
	
	public double getRemainingBalance(){
		return mRemainingBalance;
	}
	
	public String toString(){
		return 
				mTradingDate + "\t\t" +
				mStockHolderCode + "\t\t" +
				mBankCode + "\t\t" +
				mDigestMsg + "\t\t" +
				mTradingNum + "\t\t" +
				mHandlingCharge + "\t\t" +
				mStampTax + "\t\t" + 
				mTradingAmount + "\t\t" +
				mRemainingBalance
				;
	}
}
