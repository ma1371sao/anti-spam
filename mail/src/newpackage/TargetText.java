/*
 * TargetText.java
 *
 * �ļ�����
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpackage;

import java.io.*;
import java.util.*;
/**
 *
 * @author Administrator
 */
public class TargetText {
  Dictionary newDict;
  float []NB=new float[2];	//��¼����������Ϸ�������������֮��
  int []NBE=new int[2];		//��¼NB��10�ĸ����ٴη�

  public TargetText() {System.out.println("TT");
  }
  public void init(Dictionary dict){System.out.println("TT_init");
    newDict=dict;
    for(int i=0;i<2;i++){
      NB[i]=1;
      NBE[i]=0;
    }
  }

  public String categorize(Sample []v,int n,String filename){System.out.println("TT_cate");
  	
  	String str="";
    float p=0;
    String q;
    
    for(int i=0;i<n;i++){	//i=0 ��������          i=1�Ϸ�����
      fileSegment(filename,v[i].wordTable,i);	
    }
    
    p=NB[0]/(NB[0]+NB[1]);	//�������ŵĸ���P(y0|x)
    
    q=100*p+"";
    if(q.length()<5){
    	q=q+"     ";	//��5���ո�
    }
    
    str=q.substring(0,5);	//ȡ0~4
    
    
    int temp=NBE[0];
    int j=0;	//��¼�ǣ���������/�Ϸ����ţ���NBE
    //for(int i=1;i<2;i++){
    /***
    if(NBE[1]!=temp){	//������������ʱֻ�Ƚ�����������
    	if(temp>NBE[1]){	//�Ƚ���������С
        temp=NBE[1];	//NEBԽ����ô����ԽС
        j=1;			//��¼���ʴ��ߵı��
      }
    }
    else				//��������ȱȽ����ֲ���
    	if(NB[0]<NB[1])	//���ֲ���Խ����ô�������Խ��
    		j=1;
    	  
    //}
    for(int i=1;i<2;i++){
      NB[i]=NBE[i]=1;
    }
    ***/
    
    for(int i=1;i<2;i++){
        if(temp>NBE[i]){
          temp=NBE[i];
          j=i;
        }
      }
      for(int i=1;i<2;i++){
        NB[i]=NBE[i]=1;
      }
    if(j==0){
      //System.out.println("This text belongs to ��������.txt   ������Ϊ��"+str);
      //return new String("����  "+str);
      return new String("����");
    }else if(j==1){
    //  System.out.println("This text belongs to �Ϸ����� ������Ϊ��"+str);
      //return new String("�Ϸ� "+str);
      return new String("�Ϸ�");
    }
    /*
    else if(j==2){
      System.out.println("This text belongs to history");
      return new String("history");
    }
    */
    else{
      return null;
    }

    //System.out.println(NB[0]+":"+NBE[0]+" "+NB[1]+":"+NBE[1]+" "+NB[2]+":"+NBE[2]);
  }

  public int wordSegment(String Sentence,HashMap hm,int n) {
    int senLen = Sentence.length();
    int i = 0, j = 0;
    int M = 12;
    String word;
    boolean bFind = false;

      while (i < senLen) {
        int N = i + M < senLen ? i + M : senLen + 1;
        bFind = false;
        for (j = N - 1; j > i; j--) {
          word = Sentence.substring(i, j);	//��ȡi~j-1���ַ�
          if (newDict.Find(word)) {		//��dic��SDIC�����Ƿ����word
            if (j > i + 1) {
              if (hm.containsKey(word)) {
                NB[n]=NB[n]*((Float)hm.get(word)).floatValue();  //����ÿһ�����ĸ���
                while(NB[n]<1){	//���������ʵĻ�ת��Ϊ����1
                  NBE[n]=NBE[n]+1;	//��¼10�ĸ����ٴη�
                  NB[n]=NB[n]*10;
                }
              }
            }
            bFind = true;	//���ҵ��ؼ��ʣ���Ϊtrue
            i = j;
            break;
          }
        }
        if (bFind == false) {
          i = j + 1;	//��i+1��ʼ��ȡ��
        }
      }
    return 1;
  }


  public void fileSegment(String fileName,HashMap hm,int n) { //���ж���
    try {System.out.println("fileName: "+fileName);
      BufferedReader in = new BufferedReader(
          new FileReader(fileName));
      String s;
      while ((s = in.readLine()) != null) {
        wordSegment(s,hm,n);
      }
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }


}
