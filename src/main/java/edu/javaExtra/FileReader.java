package edu.javaExtra;

import java.io.File;
import java.io.IOException;

public class FileReader {

	private File[] files;
	
	FileReader(String source){
		File dir = new File(source);
		
		this.files  = dir.listFiles();
		
		for(File f : files) {
			System.out.println(f.getName());
		}
	}
	
	public File[] getFiles() {
		return this.files;
	}
	
	public void subDirList(String source){

		File dir = new File(source); 
		File[] fileList = dir.listFiles(); 
		
		try{

			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i]; 
				if(file.isFile()){
					System.out.println(file.getName());
				}else if(file.isDirectory()){
					System.out.println(file.getName());
					subDirList(file.getCanonicalPath().toString()); 
				}
			}
		}catch(IOException e){
		}

	}

}
