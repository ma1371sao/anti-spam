/*
 * Traning.java
 *
 * 训练
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpackage;

import java.util.*;
/**
 *
 * @author Administrator
 */
public class Traning {
  FMMSegment vocabulary;
  Sample []v=new Sample[2];
  Dictionary dict;

  public Traning(Dictionary newDict) {System.out.println("Tr_");
    vocabulary=new FMMSegment(newDict);
    dict=newDict;
  }



  public void train(){System.out.println("Tr_train");
    for(int i=0;i<2;i++){
      v[i]=new Sample();
      v[i].init(dict,vocabulary.vocabulary,vocabulary.NumOfVoc());
    }
    //扫描文本样例,计算P(wk|vj)
    v[0].countFreq("Sample/垃圾短信");	//计算垃圾短信中关键词的词频
    v[0].getP();
    v[1].countFreq("Sample/合法短信");
    v[1].getP();
    //v[2].countFreq("sample/history.txt");
    //v[2].getP();

  }

  public void loadVocabulary(){System.out.println("Tr_lV");
    vocabulary.fileSegment("Sample/垃圾短信");	//进入分词 FMM
    vocabulary.fileSegment("Sample/合法短信");
    //vocabulary.fileSegment("Sample/history.txt");
    
    train();
   // System.out.println("totle number of vocabulary is:"+vocabulary.NumOfVoc());
    //System.out.println(vocabulary.vocabulary.containsKey("颗粒"));

    
  }


}
