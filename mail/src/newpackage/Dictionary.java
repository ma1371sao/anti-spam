/*
 * Dictionary.java
 *
 * �ֵ�
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpackage;

// ����
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
        HashMap hm;		//a word set ��ϣ��key=�ַ��� value=Ƶ��
        
        public Dictionary()
        {
                hm = new HashMap();		
        }

        public Dictionary(String fileName)
        {System.out.println("Dic_"+fileName);
                hm = new HashMap();
                Load(fileName);
        }

        public void Load(String fileName)    //װ�غ����ֵ�
        {System.out.println("Dic_load_"+fileName);
                try
                {		//bufferedReader������װ�ַ��������ַ������뻺�棬����߶�ȡ��Ч��
                        BufferedReader in=
                                new BufferedReader(
                                        new FileReader(fileName) );

                        String s;
                        String []words;
                        while((s = in.readLine()) != null)
                        {
                                words = s.split("\t");	//Split ���������ַ�������ָ���� ���ʽ ���ָ������ \t=tab
                                hm.put(words[0],new Integer(0));	//put(key,value) �������˹ؼ��֣�û�д�����
                        }
                }
                catch(IOException e)
                {
                        System.out.println("Error: " + e);
                }
        }

        public boolean Find(String word)    //���ֵ����ѯ��
        {
                return hm.containsKey(word);	//��������ӳ���Ƿ����ָ������ӳ���ϵ
        }


}

