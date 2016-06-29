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
	public void parseRawData(){
		
		if(mRawDataFiles.size() == EMPTY){
			Utils.LOG(LOG_TAG, "No files loaded!");
			return;
		}
		
		parseRawData(mRawDataFiles);
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
	                	//Utils.LOG(LOG_TAG, "line " + line + ": " + lineStr);
		                line++;
		                
		                //TODO: to file the trade records
		                //TODO: 根据digestMsg判断类型
		                int tradingType = line;
		                
		    			String tradingDate = Utils.subStr(lineStr, 0, 9);
		    			String stockHolderCode = Utils.subStr(lineStr, 10, 20);
		    			String bankCode = Utils.subStr(lineStr, 25, 31);
		    			String digestMsg = Utils.subStr(lineStr, 36, 44);
		    			//TODO: digestMsg长度不一致，会影响后面的判断，需要by case handle
		    			
		    			double tradingNum = Utils.subStrToDouble(lineStr, 0, 9);
		    			double handlingCharge = Utils.subStrToDouble(lineStr, 0, 9);
		    			double stampTax = Utils.subStrToDouble(lineStr, 0, 9);
		    			double tradingAmount = Utils.subStrToDouble(lineStr, 0, 9);
		    			double rememainingBalance  = Utils.subStrToDouble(lineStr, 0, 9);
		                
		                TradeRecord tr = new TradeRecord(
		            			 tradingType,
		            			 tradingDate,
		            			 stockHolderCode,
		            			 bankCode,
		            			 digestMsg,
		            			 tradingNum,
		            			 handlingCharge,
		            			 stampTax,
		            			 tradingAmount,
		            			 rememainingBalance);
		                
		                Utils.LOG(LOG_TAG, tr.toString());
		                mTradeRecordList.add(tr);
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
}
