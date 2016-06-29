package com.youq.stockbill;

public class TradeRecord {

	private int mTradingType;			//unique trading type
	private static final int TRADING_TYPE_STOCK_BUY = 1;		//֤ȯ����
	private static final int TRADING_TYPE_STOCK_SALE = 2;		//֤ȯ����
	private static final int TRADING_TYPE_BANK_WITHDRAW = 3;	//����תȡ
	private static final int TRADING_TYPE_BANK_DEPOSIT = 4;		//����ת�� 
	private static final int TRADING_TYPE_MARGIN_BUY_TTL = 5;	//��֤���Ʒ�깺������
	private static final int TRADING_TYPE_MARGIN_SALE_TTL = 6;	//��֤���Ʒ���������	 
	
	private String mTradingDate;		//��������   
	private String mStockHolderCode;		//�ɶ�����
	private String mBankCode;			//���д���
	private String mDigestMsg;			//ժ                   Ҫ
	private double mTradingNum;			//�ɽ��� �ɽ�����    
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
