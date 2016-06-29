package com.youq.stockbill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RawDataParser {


	private String LOG_TAG  = "RawDataParser";
	private String mPath = null;
	private ArrayList<File> mRawDataFiles = new ArrayList<File>();
	private ArrayList<String> mRawDataFileNames = new ArrayList<String>();
//	private FileLoader mFileLoader = null;
	
	//all TradeRecords parsed from RawData files
	private ArrayList<TradeRecord> mTradeRecordList = new ArrayList<TradeRecord>();
	
	private static final int EMPTY = 0;	
	
	public RawDataParser(String path){
		mPath = path;
//		mFileLoader = new FileLoader();
		loadFilesFromPath(mPath);
//		loadFileNamesFromPath(mPath);
		
	}
	
	//init mRawDataFileNames
	public void loadFileNamesFromPath(String path){
		
		String [] fileNames = new File(path).list();
		System.out.println("Directory: "+ path + "\nFile nums: " + fileNames.length);
		
		for(int i=0; i<fileNames.length; i++){
			System.out.println("Load file: "+fileNames[i]);
			mRawDataFileNames.add(fileNames[i]);
		}
	}
	
	//init mRawDataFiles
	private void loadFilesFromPath(String path){
		String [] fileNames = new File(path).list();
		System.out.println("Directory: "+ path + "\nFile nums: " + fileNames.length);
		
		for(int i=0; i<fileNames.length; i++){
			System.out.println("Load file: "+fileNames[i]);
			mRawDataFiles.add(new File(fileNames[i]));
		}

	}
	
	//parse raw files
	public void parseRawData(){
//		if(mRawDataFileNames.size() == EMPTY){
//			Utils.LOG(LOG_TAG, "No file names loaded!");
//			return;
//		}
		
		for(String fileName : mRawDataFileNames){
			mRawDataFiles.add(new File(fileName));
		}
		
		if(mRawDataFiles.size() == EMPTY){
			Utils.LOG(LOG_TAG, "No files loaded!");
			return;
		}
		
		parseRawData(mRawDataFiles);
	}
	
	public ArrayList<TradeRecord> parseRawData(String path){
		String [] fileNames = new File(path).list();
		for(String str : fileNames)
		{
            String encoding="GBK";
            File file=new File(str);
            if(file.isFile() && file.exists()){ //判断文件是否存在
            	try{
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    System.out.println(lineTxt);
                }
                read.close();
            	}
            	catch(IOException e){}
		}
            else{
            	Utils.LOG(LOG_TAG, "file not exsits!");
            }
		}
		return mTradeRecordList;
	}
	
	
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
	                System.out.println("line " + line + ": " + lineStr);
	                line++;
	                
	                //TODO:
	                
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

	private String readLine(File rawFile)
	{

		return null;
	}
}
