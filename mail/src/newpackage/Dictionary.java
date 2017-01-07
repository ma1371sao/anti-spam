/*
 * Dictionary.java
 *
 * 字典
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpackage;

// 典类
// Class for Dictionary
//
import java.util.*;
import java.io.*;
import java.lang.*;
/**
 *
 * @author Administrator
 */
public class Dictionary
{
        HashMap hm;		//a word set 哈希表，key=字符串 value=频率
        
        public Dictionary()
        {
                hm = new HashMap();		
        }

        public Dictionary(String fileName)
        {System.out.println("Dic_"+fileName);
                hm = new HashMap();
                Load(fileName);
        }

        public void Load(String fileName)    //装载汉语字典
        {System.out.println("Dic_load_"+fileName);
                try
                {		//bufferedReader用来包装字符流，将字符流放入缓存，来提高读取的效率
                        BufferedReader in=
                                new BufferedReader(
                                        new FileReader(fileName) );

                        String s;
                        String []words;
                        while((s = in.readLine()) != null)
                        {
                                words = s.split("\t");	//Split 是用来将字符串根据指定的 表达式 来分割成数组 \t=tab
                                hm.put(words[0],new Integer(0));	//put(key,value) 仅存入了关键字，没有存数字
                        }
                }
                catch(IOException e)
                {
                        System.out.println("Error: " + e);
                }
        }

        public boolean Find(String word)    //从字典里查询词
        {
                return hm.containsKey(word);	//用来检查此映射是否包含指定键的映射关系
        }


}

