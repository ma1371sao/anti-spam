/*
 * JSplashWindow.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package newpackage;

//������������

import javax.swing.*;
import java.awt.*;
import java.net.*;

/**
 *
 * @author Administrator
 */
public  class JSplashWindow extends JWindow implements Runnable {
  Thread  splashThread=null;
  boolean show=false;
  NewJFrame frame = new NewJFrame();//****************************
  
  public JSplashWindow() {
  	//frame.setTitle("�������Ź�����");
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));	//�������ָ��
    JPanel splash = new JPanel(new BorderLayout());
    /*  ��ȡͼƬ�ļ�  */
    URL url = getClass().getResource("/image/bbb.jpg");
    if(url != null){
      splash.add(new JLabel(new ImageIcon(url)),
      BorderLayout.CENTER);
    }
    setContentPane(splash);
    Dimension screen = getToolkit().getScreenSize();
    pack();
/*  ʹ���ھ�����ʾ */
    setLocation((screen.width - getSize().width) / 2,
	          (screen.height - getSize().height) / 2);  
  }

  public void start(){
  	
     
    this.toFront();
    splashThread=new Thread(this);
    splashThread.start();
  }

  public void run(){
    try { 
          this.toFront();
          show();
          /* ��ʱ3��󣬹رմ���  */
          Thread.sleep(3000);  
         }
   catch (Exception ex) {
   ex.printStackTrace();
 }
 show=true;
 frame.AAmain();
 this.dispose();
  }


  public static void main(String[] args)
  {
     
	  System.out.println("JS");
     
     JSplashWindow splash = new JSplashWindow();	//�����������
     splash.start();
     System.out.println("JS");
    
     /*  ��ʾ�������棬3���Ӻ��Զ���ʧ  */
    
  }
}
