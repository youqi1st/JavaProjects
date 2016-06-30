package com.youq.stockbill;

public class TradeRecord {

	private int mTradingType;			//unique trading type - ��mDigestMsg�����õ�
	private String mStockName;			//֤ȯ���� -��mDigestMsg�����õ�
	
	public static final int TRADING_TYPE_STOCK_BUY = 1;		//֤ȯ����
	public static final int TRADING_TYPE_STOCK_SALE = 2;		//֤ȯ����
	public static final int TRADING_TYPE_BANK_WITHDRAW = 3;	//����תȡ
	public static final int TRADING_TYPE_BANK_DEPOSIT = 4;		//����ת�� 
	public static final int TRADING_TYPE_MARGIN_BUY_TTL = -1;	//��֤���Ʒ�깺������
	public static final int TRADING_TYPE_MARGIN_SALE_TTL = -1;	//��֤���Ʒ���������	 
	public static final int TRADING_TYPE_DIVIDEND_EARNING_STOCK = 7;	//��Ϣ���� 
	public static final int TRADING_TYPE_DIVIDEND_EARNING_TTL = 8;	//��Ϣ���������� 
	public static final int TRADING_TYPE_INTEREST_EARNING = 9;	//������Ϣ�鱾
	public static final int TRADING_TYPE_DIVIDEND_TAX = 10;	//��������˰����
	
	private String mTradingDate;		//��������   
	private String mStockHolderCode;		//�ɶ�����
	private String mBankCode;			//���д���
	private String mDigestMsg;			//ժ                   Ҫ
	private double mTradingNum;			//�ɽ��� 
	private double mTradingPrice;			//�ɽ�����    
	private double mHandlingCharge;		//������
	private double mStampTax;			//ӡ��˰��
	private double mTradingAmount;		//�䶯���  
	private double mRemainingBalance;	//�ʽ����
	
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
