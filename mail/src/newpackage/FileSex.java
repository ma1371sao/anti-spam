/*
 * FileSex.java
 *
 * ��ȡ�ļ�
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
public class FileSex {	//ȡ�����е�*.txt�ļ�
	FilenameFilter select1;
	FilenameFilter select2;
	boolean isDir;
	File[] ff;
	int t;
	int ttt;
	
	String[] dir;
	
	public FileSex(){System.out.println("FS");
		select1=new FileListFilter("txt");//��"*.txt"
		select2=new FileListFilter();// "*.txt"��Ŀ¼
	    isDir=false;
	    ff=new File[3000];
	    t=0;
	    ttt=0;
	    dir=new String[3000];//��¼.txt�ļ���
	}
	
	public String[] getDir(){
		return dir;
	}
	
	public  String[] amain(File myDir){
		isDir=myDir.isDirectory()?true:false;	//���myDir��ʾ����һ��Ŀ¼�ͷ���true������false
		String[] sss=new String[3000]; //��¼.txt�ļ���
		int t=0;
		
		while(isDir){
			
			File[] contents1;
			File[] contents2;
			isDir=false;
			
			contents1=myDir.listFiles(select1);	//���س���·�������飬��Ŀ¼�д˳���·������ʾ����ָ�����������ļ���Ŀ¼
			if(contents1!=null){
				for(File file:contents1){//�������ȡ��ÿ���ļ������*.txt�ļ�
			//		System.out.println(file+" is a "+(file.isDirectory()?"directory":"file")+"\n");
				    sss[t]=file+"";
			//	    System.out.println(sss[t]+"\n");
			   //     dir[t]=sss[t];
				    t++;
				    
				}				
			}
			
		//    System.out.println("*****************");
		    
		    contents2=myDir.listFiles(select2);			
			if(contents2!=null){
				for(File file:contents2){	    
				    if(file.isDirectory()){//����ȡ��ÿ����ļ���
		//		    	System.out.println(file+" is a "+(file.isDirectory()?"directory":"file")+"\n");    
				        amain(file);//******************
				    }
				}	
			}
			
			
		}
		
	  
        for(int i=0;i<sss.length;i++){
        	if(sss[i]!=null){	    
        	    dir[ttt]=sss[i]+"";
        	    
        	  //  System.out.println(sst[i]+"");
        	  //  System.out.println(dir[ttt]+"");
        	    ttt++;
        	}	
        	
        }
	//	System.out.println(sst.length+"");
		
		return sss;
	}
	
	
	
		public static void main(String[] args){
			FileSex ss=new FileSex();
			File myDir=new File("C:/����");
	
        
        ss.amain(myDir);
    
        for(String str:ss.getDir()){		
        	if(str!=null){
      
       // 	    System.out.println(str+"");
        	}	
        }
        
        
        
	}
	
	
}
