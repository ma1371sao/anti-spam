/*
 * FMMSegment.java
 *
 * �ִ�
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
  int totleNumber; //��¼���У�vocabulary���ܹ��ʻ���
  HashMap vocabulary; //��¼���ı��л�ȡ�����Ĵ�

  public FMMSegment() {
  }

  public FMMSegment(Dictionary newDic) {System.out.println("FMM");
    dic = newDic;
    totleNumber = 0;
    vocabulary = new HashMap();
  }

  public int wordSegment(String Sentence) {System.out.println("FMM_���ķִ�"); //���ķִ�
    int senLen = Sentence.length();
    int i = 0, j = 0;
    int M = 12;	//ÿ��ѭ���ִ�����󳤶�
    String word;
    boolean bFind = false;
    FileAppender fa=new FileAppender("vocabulary.txt");

      while (i < senLen) {
        int N = i + M < senLen ? i + M : senLen + 1;
        bFind = false;
        for (j = N - 1; j > i; j--) {
          word = Sentence.substring(i, j);	//��ȡSentence��i��j-1���ַ�����word
          if (dic.Find(word)) {	//��dic���洢SDIC.txt��dic������dic���Ƿ������word��ͬ�Ĵ�
            if (j > i + 1) {	//����һ����
              if (!vocabulary.containsKey(word)) {	//���vocabulary�в�����word�����
                vocabulary.put(word, new Float(0));	//��word����vocabulary
                totleNumber++; //�ۼ��ܴʻ���
                //����ȡ�ĵ���д���ļ�
                fa.append(word);
              
     //           System.out.println(word + " ");
              }
            }
            bFind = true;	//��SDIC���ҵ��ʣ���ôΪtrue
            i = j;	//�ӵ�ǰ�������
            break;	//�ӵ�ǰ�ʺ����M���Ȼ����ַ�����β��Ѱ�Ҵ�
          }
        }
        if (bFind == false) {	//��N-1��i+1��û���ҵ�SDIC���е�vocabulary��û�еĵ���
          i = j + 1;
        }
      }
    return 1;
  }
  

  public void fileSegment(String fileName) { //��ȡfilenameĿ¼�����е�*.txt�ļ�������Щ�ļ����зִʴ���
    try {
    	
    	
    	
    	
    	
        FileSex ss=new FileSex();
	File myDir=new File(fileName);

        ss.amain(myDir);	//����Ŀ¼�µ�����.txt��ȫ����������
        for(String str:ss.getDir()){	//�ȼ���for(int str=0;str<�ַ�������;str++) 	
        	if(str!=null){		//dir����
      
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

