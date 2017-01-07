/**
 * ����õĴ�д���ļ�
 */
package newpackage;

import java.io.*;

public class FileAppender {
  String filename;
  String word;

  public FileAppender(String fn) {
    filename=fn;
    word=new String();
  }

  public void loadFile(){	//���ļ���ԭ�е�����ȡ��
    try{
      BufferedReader in = new BufferedReader(new FileReader(filename));
      String s;
      while ( (s = in.readLine()) != null) {
        word=word.concat(s+"\n");	//��s+"\n"���ӵ�word�Ľ�β
        //System.out.println(s);
      }

    }catch(IOException e){
      System.out.println(e);
    }
    //System.out.println(word);
  }

  public void append(String w){	//����ȡ�ĵ�����ԭ�е���������������д���ļ�
    loadFile();System.out.println("FA_append");
    try{
      BufferedWriter out = new BufferedWriter(new FileWriter(filename));
      word=word.concat(w);				//��w��wordԭ�������ݴ�����
      //System.out.println("FA_append_"+word);
      out.write(word,0,word.length());	//��wordд��Ŀ���ļ�
      out.flush();
    }catch(IOException e){
      System.out.println(e);
    }
    word="";
  }

}
