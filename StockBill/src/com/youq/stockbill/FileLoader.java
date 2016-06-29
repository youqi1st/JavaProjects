package com.youq.stockbill;
import java.io.*;
import java.util.ArrayList;

public class FileLoader {

	private ArrayList<File>  mFiles = new ArrayList<File>();
	private ArrayList<String>  mFileNames = new ArrayList<String>();
	
	public FileLoader(){
		
	}
	
	public ArrayList<String> loadFileNamesFromPath(String path){
		
		String [] fileNames = new File(path).list();
		System.out.println("Directory: "+ path + "\nFile nums: " + fileNames.length);
		
		for(int i=0; i<fileNames.length; i++){
			System.out.println("Load file: "+fileNames[i]);
		}
		
		return mFileNames;
	}

	public ArrayList<File> loadFilesFromPath(String path){
		String [] fileNames = new File(path).list();
		System.out.println("Directory: "+ path + "\nFile nums: " + fileNames.length);
		
		for(int i=0; i<fileNames.length; i++){
			System.out.println("Load file: "+fileNames[i]);
			mFiles.add(new File(fileNames[i]));
		}
		
		return mFiles;
	}
	
	
//TODO: sort by date, in which filename means date
	public boolean sortByFileName(){
		
		return false;
	}
}
