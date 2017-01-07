/*
 * FileSex.java
 *
 * 提取文件
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
public class FileSex {	//取出所有的*.txt文件
	FilenameFilter select1;
	FilenameFilter select2;
	boolean isDir;
	File[] ff;
	int t;
	int ttt;
	
	String[] dir;
	
	public FileSex(){System.out.println("FS");
		select1=new FileListFilter("txt");//仅"*.txt"
		select2=new FileListFilter();// "*.txt"与目录
	    isDir=false;
	    ff=new File[3000];
	    t=0;
	    ttt=0;
	    dir=new String[3000];//记录.txt文件名
	}
	
	public String[] getDir(){
		return dir;
	}
	
	public  String[] amain(File myDir){
		isDir=myDir.isDirectory()?true:false;	//如果myDir表示的是一个目录就返回true，否则false
		String[] sss=new String[3000]; //记录.txt文件名
		int t=0;
		
		while(isDir){
			
			File[] contents1;
			File[] contents2;
			isDir=false;
			
			contents1=myDir.listFiles(select1);	//返回抽象路径名数组，在目录中此抽象路径名表示满足指定过滤器的文件和目录
			if(contents1!=null){
				for(File file:contents1){//这里可以取出每层文件夹里的*.txt文件
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
				    if(file.isDirectory()){//这里取出每层的文件夹
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
			File myDir=new File("C:/测试");
	
        
        ss.amain(myDir);
    
        for(String str:ss.getDir()){		
        	if(str!=null){
      
       // 	    System.out.println(str+"");
        	}	
        }
        
        
        
	}
	
	
}
