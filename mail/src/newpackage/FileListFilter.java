/*
 * FileListFilter.java
 *
 * 文件过滤 识别*.txt
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package newpackage;

import java.io.File;
import java.io.FilenameFilter;
/**
 *
 * @author Administrator
 */
public class FileListFilter implements FilenameFilter {	//文件名过滤器
	
	private String extension;
	boolean boo;
	
	public FileListFilter(){
	    boo=true;
	}
	
	public FileListFilter(String extension){	//过滤以.extension为结尾的文件
		this.extension=extension;
		boo=false;
	}
	
	public boolean accept(File directory,String filename){	//directory表示文件的当前目录，filename文件名
		System.out.println("FLF");
		boolean fileOK=true;
		if(extension!=null){
			fileOK&=filename.endsWith('.'+extension);
		}
		
		if(boo){
			return true;
		}
					
		return fileOK;    
	}
}
