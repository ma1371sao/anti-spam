/*
 * Sample.java
 *
 * ����Ƶ�ʸ���
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpackage;

import java.util.*;
import java.io.*;
/**
 *	�����Ƶ
 * @author Administrator
 */
public class Sample {
  Dictionary dic;
  HashMap wordTable= new HashMap();	//��Ŵ�����������
  int totleWord;
  int vocNum;

  public Sample() {
	 
  }

  public void init(Dictionary newDic,HashMap hm,int n) {
    dic = newDic;
    totleWord=0;
    wordTable.putAll(hm);	//�����еķִʽ�����Ƶ�wordTable
    vocNum=n;
  }

  public int wordSegment(String Sentence) { //���ķִ�+����Ƶ��
	  System.out.println("Sample_�ִ�");
    int senLen = Sentence.length();
    int i = 0, j = 0;
    int M = 12;
    String word;
    boolean bFind = false;

      while (i < senLen) {
        int N = i + M < senLen ? i + M : senLen + 1;
        bFind = false;
        for (j = N - 1; j > i; j--) {
          word = Sentence.substring(i, j);	//��ȡSentence�д�i��j���ַ��������丳ֵ��j
          if (dic.Find(word)) {	//��dic���Ƿ����word
            if (j > i + 1) {
              totleWord++;  //ͳ������ܴʻ���
              if (wordTable.containsKey(word)) {	//�������word�����/��
                float c=((Float)wordTable.get(word)).floatValue()+1;	//ȡ��word��Ӧ��ֵ��Ƶ��+1
                wordTable.put(word,new Float(c));	//���²����µ�ֵ/Ƶ��
               //ͳ��ÿ���ڵ������ı��г��ֵĴ���
              }
            }
            bFind = true;
            i = j;
            break;	//��Ϊ�����ڴ��дʣ������ҵ�һ��֮�����ٿ������֮�л���û�д�
          }
        }
        if (bFind == false) {
          i = j + 1;
        }
      }
    return 1;
  }

  public void getP(){System.out.println("S_getP");	//����Ƶ�� P(a|y0)
    try {
      BufferedReader in = new BufferedReader(
          new FileReader("vocabulary.txt"));
      String s;
      while ( (s = in.readLine()) != null) {
        //System.out.println(s);
        if(wordTable.containsKey(s)){
          float nk=((Float)wordTable.get(s)).floatValue();	//�ùؼ��ʶ�Ӧ�Ĵ�Ƶ
          float p=(nk+1)/(vocNum+totleWord);	//���Ƶ��  ����Ƶ+�ֵ�SDIC�е�1����/���ܵĴ�Ƶ��+�ֵ��еĴ�����
          //System.out.println(s+" "+new Float(p));
          wordTable.put(s,new Float(p));
          
        }
      }
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }


  public void countFreq(String fileName) { //�����Ƶ
    try {
    	
    	
    	
    	FileSex ss=new FileSex();
		File myDir=new File(fileName);

        ss.amain(myDir);				//�����е������ǽ�Ŀ¼�е�*.txt�ļ�ȡ��������dir��
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
