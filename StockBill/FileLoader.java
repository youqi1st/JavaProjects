package com.youq.stockbill;
import java.io.*; //引入java.io包中所有的类
import java.util.ArrayList;

public class FileLoader {

	private ArrayList<File>  files = new ArrayList<File>();
	
	public FileLoader(){
		
	}
	
	public ArrayList<File> loadFromPath(String path){

		
		String [] fileNames = new File(path).list();
		System.out.println("Directory: "+ path + "\nFile nums: " + fileNames.length);
		
		for(int i=0; i<fileNames.length; i++){
			File f = new File(path, fileNames[i]);
			System.out.println("Load file: "+fileNames[i]);

			files.add(f);
		}
		
		return files;
	}
	

}
