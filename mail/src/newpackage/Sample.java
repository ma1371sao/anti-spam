/*
 * Sample.java
 *
 * 计算频率概率
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpackage;

import java.util.*;
import java.io.*;
/**
 *	计算词频
 * @author Administrator
 */
public class Sample {
  Dictionary dic;
  HashMap wordTable= new HashMap();	//存放词与条件概率
  int totleWord;
  int vocNum;

  public Sample() {
	 
  }

  public void init(Dictionary newDic,HashMap hm,int n) {
    dic = newDic;
    totleWord=0;
    wordTable.putAll(hm);	//把所有的分词结果复制到wordTable
    vocNum=n;
  }

  public int wordSegment(String Sentence) { //中文分词+计算频率
	  System.out.println("Sample_分词");
    int senLen = Sentence.length();
    int i = 0, j = 0;
    int M = 12;
    String word;
    boolean bFind = false;

      while (i < senLen) {
        int N = i + M < senLen ? i + M : senLen + 1;
        bFind = false;
        for (j = N - 1; j > i; j--) {
          word = Sentence.substring(i, j);	//截取Sentence中从i到j的字符串并将其赋值给j
          if (dic.Find(word)) {	//看dic中是否存在word
            if (j > i + 1) {
              totleWord++;  //统计类别总词汇数
              if (wordTable.containsKey(word)) {	//如果存在word这个键/词
                float c=((Float)wordTable.get(word)).floatValue()+1;	//取出word对应的值即频率+1
                wordTable.put(word,new Float(c));	//重新插入新的值/频率
               //统计每个在单词在文本中出现的次数
              }
            }
            bFind = true;
            i = j;
            break;	//因为不存在词中词，所以找到一个之后不用再看这个词之中还有没有词
          }
        }
        if (bFind == false) {
          i = j + 1;
        }
      }
    return 1;
  }

  public void getP(){System.out.println("S_getP");	//计算频率 P(a|y0)
    try {
      BufferedReader in = new BufferedReader(
          new FileReader("vocabulary.txt"));
      String s;
      while ( (s = in.readLine()) != null) {
        //System.out.println(s);
        if(wordTable.containsKey(s)){
          float nk=((Float)wordTable.get(s)).floatValue();	//该关键词对应的词频
          float p=(nk+1)/(vocNum+totleWord);	//算出频率  （词频+字典SDIC中的1个）/（总的词频数+字典中的词数）
          //System.out.println(s+" "+new Float(p));
          wordTable.put(s,new Float(p));
          
        }
      }
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }


  public void countFreq(String fileName) { //计算词频
    try {
    	
    	
    	
    	FileSex ss=new FileSex();
		File myDir=new File(fileName);

        ss.amain(myDir);				//这三行的作用是将目录中的*.txt文件取出来放在dir中
        for(String str:ss.getDir()){		
        	if(str!=null){
      
        //	    System.out.println(str+"");
       ////////////////////////////////////////////// 
        
        	    
        	   
        	    
        	    
        BufferedReader in = new BufferedReader(new FileReader(str));
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


}
