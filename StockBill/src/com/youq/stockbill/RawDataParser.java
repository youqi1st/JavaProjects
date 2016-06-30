package com.youq.stockbill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RawDataParser {


	
	private String mPath = null;
	private ArrayList<File> mRawDataFiles = new ArrayList<File>();
	
	//all TradeRecords parsed from RawData files
	private ArrayList<TradeRecord> mTradeRecordList = new ArrayList<TradeRecord>();
	
	private static final int EMPTY = 0;	
	private final String LOG_TAG  = "RawDataParser";
	private final String PREFIX_2015 = "2015";
	private final String PREFIX_2016 = "2016";	
	
	public RawDataParser(String path){
		mPath = path;
//		mFileLoader = new FileLoader();
		loadFilesFromPath(mPath);
	}
	
	
	//init mRawDataFiles
	private void loadFilesFromPath(String path){		
		mRawDataFiles = new FileLoader().loadFilesFromPath(path);

	}
	
	//parse raw files
	public ArrayList<TradeRecord> parseRawData(){
		
		if(mRawDataFiles.size() == EMPTY){
			Utils.LOG(LOG_TAG, "No files loaded!");
			return null;
		}
		
		return parseRawData(mRawDataFiles);
	}
	
//	public ArrayList<TradeRecord> parseRawData(String path){
//		String [] fileNames = new File(path).list();
//		for(String str : fileNames)
//		{
//            String encoding="GBK";
//            File file=new File(path+str);
//            if(file.isFile() && file.exists()){ //判断文件是否存在
//            	try{
//                InputStreamReader read = new InputStreamReader(
//                new FileInputStream(file),encoding);//考虑到编码格式
//                BufferedReader bufferedReader = new BufferedReader(read);
//                String lineTxt = null;
//                while((lineTxt = bufferedReader.readLine()) != null){
//                    System.out.println(lineTxt);
//                }
//                read.close();
//            	}
//            	catch(IOException e){}
//		}
//            else{
//            	Utils.LOG(LOG_TAG, "file not exsits!");
//            }
//		}
//		return mTradeRecordList;
//	}
//	
	
	public ArrayList<TradeRecord> parseRawData(ArrayList<File> rawFiles){
		if(rawFiles == null || rawFiles.size() == 0)
		{
			Utils.LOG(LOG_TAG, "Null rawFiles!");
			return null;
		}
		
		//read mRawDataFiles one by one, maybe we can sort these files by date first.
		for(File file : rawFiles){
			if(!(file.isFile() || file.exists())){
				Utils.LOG(LOG_TAG, "file not exsits!");
				return null;
			}
			
			BufferedReader  br = null;
			try{
	            br = new BufferedReader(new FileReader(file));
	            String lineStr = null;
	            int line = 1;
	            
	          //read line by line from a raw data file
	            while ((lineStr = br.readLine()) != null) {

	                
	            	//lineStr.trim();
	                if( lineStr.startsWith(PREFIX_2015) || lineStr.startsWith(PREFIX_2016)){
	                	Utils.LOG(LOG_TAG, "line " + line + ": " + lineStr);
		                line++;
		                
		                TradeRecord tr = parseLine(lineStr);
		                //Utils.LOG(LOG_TAG, tr.toString());
		                
		                //only add TradeRecords which have types defined in TradeRecord.java to mTradeRecordList. parseLine() don't parse other type yet.
		                if(tr.getTradingType() != -1){
		                	mTradeRecordList.add(tr);
		                }
	                }
	                
	                
	                
	            }
	            br.close();
			} catch (IOException e){
				e.printStackTrace();
				return null;
			}
			finally{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return mTradeRecordList;
	}
	
	//将一行数据转换为一个TradeRecord类型
	public TradeRecord parseLine(String lineStr){
        //TODO: to file the trade records
        //TODO: 根据digestMsg判断类型
		String tmpTypeMsg = Utils.subStr(lineStr, 35, 44);		//摘                   要的前几个字
		
		
		
        int tradingType = parseTradingType(tmpTypeMsg);
        
        //TODO: By now, only parse defined tradingType.
        if(tradingType == -1){
        	return new TradeRecord(-1);
        }

		String tradingDate = "N/A";
		String stockHolderCode = "N/A";
		String bankCode = "N/A";
		String digestMsg = "N/A";	//TODO: digestMsg长度不一致，会影响后面的判断，需要by case handle
		
		double tradingNum = Utils.subStrToDouble(lineStr, 0, 9);
		double tradingPrice = 0;
		double handlingCharge = Utils.subStrToDouble(lineStr, 0, 9);
		double stampTax = Utils.subStrToDouble(lineStr, 0, 9);
		double tradingAmount = Utils.subStrToDouble(lineStr, 0, 9);
		double rememainingBalance  = Utils.subStrToDouble(lineStr, 0, 9);
		
        String[] tmpStr = lineStr.split("[ ]+");
        switch(tradingType){
        case TradeRecord.TRADING_TYPE_STOCK_BUY:
        case TradeRecord.TRADING_TYPE_STOCK_SALE:
//        	Utils.LOG(LOG_TAG, tmpStr.length + " " + tmpStr[0] + " " +tmpStr[1] + " " + tmpStr[2] + " " + tmpStr[3]);
        	
        	//证券买入的格式包含10个字段
        	if(tmpStr.length != 10)	
        	{
        		try {
					throw new Exception("TRADING_TYPE_STOCK_BUY: Wrong rawdata format, abort!");
				} catch (Exception e) {
					e.printStackTrace();
					Utils.LOG(LOG_TAG, tmpStr.length + "");
					return new TradeRecord(-1);
				}
        	}
        	
        	tradingDate = tmpStr[0];
        	stockHolderCode = tmpStr[1];
        	bankCode = tmpStr[2];
        	digestMsg = tmpStr[3];
        	tradingNum = Double.valueOf(tmpStr[4]);
        	tradingPrice = Double.valueOf(tmpStr[5]);
        	handlingCharge = Double.valueOf(tmpStr[6]);
        	stampTax = Double.valueOf(tmpStr[7]);
        	tradingAmount = Double.valueOf(tmpStr[8]);
        	rememainingBalance = Double.valueOf(tmpStr[9]);

        	break;
        case TradeRecord.TRADING_TYPE_BANK_WITHDRAW:
        	break;
        case TradeRecord.TRADING_TYPE_BANK_DEPOSIT:
        	break;
//        case TradeRecord.TRADING_TYPE_MARGIN_BUY_TTL:
//        	break;
//        case TradeRecord.TRADING_TYPE_MARGIN_SALE_TTL:
//        	break;
        case TradeRecord.TRADING_TYPE_DIVIDEND_EARNING_STOCK:
        	break;
        case TradeRecord.TRADING_TYPE_DIVIDEND_EARNING_TTL:
        	break;
        case TradeRecord.TRADING_TYPE_INTEREST_EARNING:
        	break;
        default:
        		
        	
        }
        
        TradeRecord tr = new TradeRecord(
    			 tradingType,
    			 tradingDate,
    			 stockHolderCode,
    			 bankCode,
    			 digestMsg,
    			 tradingNum,
    			 tradingPrice,
    			 handlingCharge,
    			 stampTax,
    			 tradingAmount,
    			 rememainingBalance);

		return tr;
	}


	private int parseTradingType(String tmpTypeMsg) {

		if(tmpTypeMsg == null)
		{
			Utils.LOG(LOG_TAG, "parseTradingType - tmpTypeMsg = null!");
		}
		
		int type = -1;
		
		
		if(tmpTypeMsg.startsWith("证券买入")){
			type = TradeRecord.TRADING_TYPE_STOCK_BUY;
		}
		else if(tmpTypeMsg.startsWith("证券卖出")){
			type = TradeRecord.TRADING_TYPE_STOCK_SALE;
		}
		else if(tmpTypeMsg.startsWith("银行转存")){
			type = TradeRecord.TRADING_TYPE_BANK_WITHDRAW;
		}
		else if(tmpTypeMsg.startsWith("银行转取")){
			type = TradeRecord.TRADING_TYPE_BANK_DEPOSIT;
		}
		else if(tmpTypeMsg.startsWith("保证金产品申购")){
			type = TradeRecord.TRADING_TYPE_MARGIN_BUY_TTL;
		}
		else if(tmpTypeMsg.startsWith("保证金产品赎回")){
			type = TradeRecord.TRADING_TYPE_MARGIN_SALE_TTL;
		}
		else if(tmpTypeMsg.startsWith("股息入帐")){
			type = TradeRecord.TRADING_TYPE_DIVIDEND_EARNING_STOCK;
		}
		else if(tmpTypeMsg.startsWith("股息入帐天添利")){
			type = TradeRecord.TRADING_TYPE_DIVIDEND_EARNING_TTL;
		}
		else if(tmpTypeMsg.startsWith("批量利息归本")){
			type = TradeRecord.TRADING_TYPE_INTEREST_EARNING;
		}
		else if(tmpTypeMsg.startsWith("红利差异税补扣")){
			type = TradeRecord.TRADING_TYPE_DIVIDEND_TAX;
		}
		else{
			//Utils.LOG(LOG_TAG, tmpTypeMsg);
		}
		return type;
	}
}
