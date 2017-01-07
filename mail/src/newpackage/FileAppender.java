/**
 * 将获得的词写入文件
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

  public void loadFile(){	//将文件中原有的内容取出
    try{
      BufferedReader in = new BufferedReader(new FileReader(filename));
      String s;
      while ( (s = in.readLine()) != null) {
        word=word.concat(s+"\n");	//将s+"\n"连接到word的结尾
        //System.out.println(s);
      }

    }catch(IOException e){
      System.out.println(e);
    }
    //System.out.println(word);
  }

  public void append(String w){	//将获取的单词与原有的内容连接起来并写入文件
    loadFile();System.out.println("FA_append");
    try{
      BufferedWriter out = new BufferedWriter(new FileWriter(filename));
      word=word.concat(w);				//将w与word原本的内容串起来
      //System.out.println("FA_append_"+word);
      out.write(word,0,word.length());	//将word写入目标文件
      out.flush();
    }catch(IOException e){
      System.out.println(e);
    }
    word="";
  }

}
