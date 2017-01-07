/*
 * FMMSegment.java
 *
 * 分词
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpackage;

import java.lang.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class FMMSegment {
  Dictionary dic;
  int totleNumber; //记录文中（vocabulary）总共词汇数
  HashMap vocabulary; //记录从文本中获取的中文词

  public FMMSegment() {
  }

  public FMMSegment(Dictionary newDic) {System.out.println("FMM");
    dic = newDic;
    totleNumber = 0;
    vocabulary = new HashMap();
  }

  public int wordSegment(String Sentence) {System.out.println("FMM_中文分词"); //中文分词
    int senLen = Sentence.length();
    int i = 0, j = 0;
    int M = 12;	//每次循环字串的最大长度
    String word;
    boolean bFind = false;
    FileAppender fa=new FileAppender("vocabulary.txt");

      while (i < senLen) {
        int N = i + M < senLen ? i + M : senLen + 1;
        bFind = false;
        for (j = N - 1; j > i; j--) {
          word = Sentence.substring(i, j);	//截取Sentence中i到j-1的字符串给word
          if (dic.Find(word)) {	//此dic即存储SDIC.txt的dic，查找dic中是否存在与word相同的词
            if (j > i + 1) {	//大于一个字
              if (!vocabulary.containsKey(word)) {	//如果vocabulary中不包含word这个词
                vocabulary.put(word, new Float(0));	//将word放入vocabulary
                totleNumber++; //累加总词汇数
                //将获取的单词写入文件
                fa.append(word);
              
     //           System.out.println(word + " ");
              }
            }
            bFind = true;	//在SDIC中找到词，那么为true
            i = j;	//从当前词向后找
            break;	//从当前词后面的M长度或至字符串结尾内寻找词
          }
        }
        if (bFind == false) {	//在N-1到i+1内没有找到SDIC中有但vocabulary中没有的单词
          i = j + 1;
        }
      }
    return 1;
  }
  

  public void fileSegment(String fileName) { //获取filename目录下所有的*.txt文件并对这些文件进行分词处理
    try {
    	
    	
    	
    	
    	
        FileSex ss=new FileSex();
	File myDir=new File(fileName);

        ss.amain(myDir);	//将该目录下的素有.txt名全部储存起来
        for(String str:ss.getDir()){	//等价于for(int str=0;str<字符串长度;str++) 	
        	if(str!=null){		//dir不空
      
        	 //   System.out.println(str+"");
       ////////////////////////////////////////////// 	
    	
    	
    	
    	
      BufferedReader in = new BufferedReader(new FileReader(str));	//dir[str]
      String s;
      
      while ( (s = in.readLine()) != null) {
        wordSegment(s);
      }
    }
    
    
     	    
        	}	
        }
    	
    	
    
    
    
    
    catch (IOException e) {
      System.out.println(e);
    } 
    
  }






  public int NumOfVoc() {
    return totleNumber;
  }
}

