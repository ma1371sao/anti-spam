/*
 * Traning.java
 *
 * ѵ��
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
    //ɨ���ı�����,����P(wk|vj)
    v[0].countFreq("Sample/��������");	//�������������йؼ��ʵĴ�Ƶ
    v[0].getP();
    v[1].countFreq("Sample/�Ϸ�����");
    v[1].getP();
    //v[2].countFreq("sample/history.txt");
    //v[2].getP();

  }

  public void loadVocabulary(){System.out.println("Tr_lV");
    vocabulary.fileSegment("Sample/��������");	//����ִ� FMM
    vocabulary.fileSegment("Sample/�Ϸ�����");
    //vocabulary.fileSegment("Sample/history.txt");
    
    train();
   // System.out.println("totle number of vocabulary is:"+vocabulary.NumOfVoc());
    //System.out.println(vocabulary.vocabulary.containsKey("����"));

    
  }


}
