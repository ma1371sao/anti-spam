/*
 * FileListFilter.java
 *
 * �ļ����� ʶ��*.txt
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
public class FileListFilter implements FilenameFilter {	//�ļ���������
	
	private String extension;
	boolean boo;
	
	public FileListFilter(){
	    boo=true;
	}
	
	public FileListFilter(String extension){	//������.extensionΪ��β���ļ�
		this.extension=extension;
		boo=false;
	}
	
	public boolean accept(File directory,String filename){	//directory��ʾ�ļ��ĵ�ǰĿ¼��filename�ļ���
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
