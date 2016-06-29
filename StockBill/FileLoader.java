package com.youq.stockbill;
import java.io.*;
import java.util.ArrayList;

public class FileLoader {

	private ArrayList<File>  mFiles = new ArrayList<File>();
	
	public FileLoader(){
		
	}
	
	public ArrayList<File> loadFromPath(String path){
		
		String [] fileNames = new File(path).list();
		System.out.println("Directory: "+ path + "\nFile nums: " + fileNames.length);
		
		for(int i=0; i<fileNames.length; i++){
			File f = new File(path, fileNames[i]);
			System.out.println("Load file: "+fileNames[i]);

			mFiles.add(f);
		}
		
		return mFiles;
	}
	
//TODO: sort by date, in which filename means date
	public boolean sortByFileName(){
		
		return false;
	}
}
