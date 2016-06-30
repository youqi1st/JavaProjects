package com.youq.stockbill;

public class TradeRecord {

	private int mTradingType;			//unique trading type - 从mDigestMsg解析得到
	private String mStockName;			//证券名称 -从mDigestMsg解析得到
	
	public static final int TRADING_TYPE_STOCK_BUY = 1;		//证券买入
	public static final int TRADING_TYPE_STOCK_SALE = 2;		//证券卖出
	public static final int TRADING_TYPE_BANK_WITHDRAW = 3;	//银行转取
	public static final int TRADING_TYPE_BANK_DEPOSIT = 4;		//银行转存 
	public static final int TRADING_TYPE_MARGIN_BUY_TTL = -1;	//保证金产品申购天添利
	public static final int TRADING_TYPE_MARGIN_SALE_TTL = -1;	//保证金产品赎回天添利	 
	public static final int TRADING_TYPE_DIVIDEND_EARNING_STOCK = 7;	//股息入帐 
	public static final int TRADING_TYPE_DIVIDEND_EARNING_TTL = 8;	//股息入帐天添利 
	public static final int TRADING_TYPE_INTEREST_EARNING = 9;	//批量利息归本
	public static final int TRADING_TYPE_DIVIDEND_TAX = 10;	//红利差异税补扣
	
	private String mTradingDate;		//发生日期   
	private String mStockHolderCode;		//股东代码
	private String mBankCode;			//银行代码
	private String mDigestMsg;			//摘                   要
	private double mTradingNum;			//成交数 
	private double mTradingPrice;			//成交均价    
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
			double tradingPrice,
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
		mTradingPrice = tradingPrice;
		mHandlingCharge = handlingCharge;
		mStampTax = stampTax;
		mTradingAmount = tradingAmount;
		mRemainingBalance = rememainingBalance;
		
	}
	
	public double getTradingType(){
		return mTradingType;
	}
	public void setStockName(String sn){
		mStockName = sn;
	}
	public String getStockName(){
		return mStockName;
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
				mTradingType + "\t" +
				mTradingDate + "\t" +
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
