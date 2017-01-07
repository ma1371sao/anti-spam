/*
 * TargetText.java
 *
 * 文件过滤
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
  float []NB=new float[2];	//记录垃圾短信与合法短信条件概率之积
  int []NBE=new int[2];		//记录NB是10的负多少次方

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
    
    for(int i=0;i<n;i++){	//i=0 垃圾短信          i=1合法短信
      fileSegment(filename,v[i].wordTable,i);	
    }
    
    p=NB[0]/(NB[0]+NB[1]);	//垃圾短信的概率P(y0|x)
    
    q=100*p+"";
    if(q.length()<5){
    	q=q+"     ";	//加5个空格
    }
    
    str=q.substring(0,5);	//取0~4
    
    
    int temp=NBE[0];
    int j=0;	//记录是（垃圾短信/合法短信）的NBE
    //for(int i=1;i<2;i++){
    /***
    if(NBE[1]!=temp){	//当数量级不等时只比较数量级即可
    	if(temp>NBE[1]){	//比较数量级大小
        temp=NBE[1];	//NEB越大，那么概率越小
        j=1;			//记录概率大者的标号
      }
    }
    else				//数量级相等比较数字部分
    	if(NB[0]<NB[1])	//数字部分越大那么整体概率越大
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
      //System.out.println("This text belongs to 垃圾短信.txt   垃圾率为："+str);
      //return new String("垃圾  "+str);
      return new String("垃圾");
    }else if(j==1){
    //  System.out.println("This text belongs to 合法短信 垃圾率为："+str);
      //return new String("合法 "+str);
      return new String("合法");
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
          word = Sentence.substring(i, j);	//截取i~j-1的字符
          if (newDict.Find(word)) {		//在dic即SDIC中找是否存在word
            if (j > i + 1) {
              if (hm.containsKey(word)) {
                NB[n]=NB[n]*((Float)hm.get(word)).floatValue();  //计算每一个类别的概率
                while(NB[n]<1){	//将条件概率的积转换为大于1
                  NBE[n]=NBE[n]+1;	//记录10的负多少次方
                  NB[n]=NB[n]*10;
                }
              }
            }
            bFind = true;	//若找到关键词，则为true
            i = j;
            break;
          }
        }
        if (bFind == false) {
          i = j + 1;	//从i+1开始截取词
        }
      }
    return 1;
  }


  public void fileSegment(String fileName,HashMap hm,int n) { //按行读入
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
