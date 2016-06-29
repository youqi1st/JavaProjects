package com.youq.stockbill;

import java.io.File;
import java.util.ArrayList;

public class RawDataParser {

	private String LOG_TAG  = "RawDataParser";
	private String mPath = null;
	private ArrayList<File> mRawDataFiles = null;
	private FileLoader mFileLoader = null;
	
	public RawDataParser(){
		
	}
	
	public RawDataParser(String path){
		mPath = path;
		mFileLoader = new FileLoader();
		mRawDataFiles = getRawDataFiles(mPath);
		
	}
	
	public ArrayList<File> getRawDataFiles(String path){
		return mFileLoader.loadFromPath(path);
	}
	
	//parse raw files
	public void parseRawData(ArrayList<File> rawFiles){
		if(rawFiles == null)
		{
			Utils.LOG(LOG_TAG, "Null rawFiles!");
			return;
		}
		
		//read mRawDataFiles one by one, maybe we can sort these files by date first.
		//read line by line from a raw data file
		for(File f : mRawDataFiles){
			
		}
	}
}
