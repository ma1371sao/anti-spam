/*
 * JSplashWindow.java
 *
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package newpackage;

//程序启动界面

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
  	//frame.setTitle("垃圾短信过滤器");
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));	//设置鼠标指针
    JPanel splash = new JPanel(new BorderLayout());
    /*  读取图片文件  */
    URL url = getClass().getResource("/image/bbb.jpg");
    if(url != null){
      splash.add(new JLabel(new ImageIcon(url)),
      BorderLayout.CENTER);
    }
    setContentPane(splash);
    Dimension screen = getToolkit().getScreenSize();
    pack();
/*  使窗口居中显示 */
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
          /* 延时3秒后，关闭窗口  */
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
     
     JSplashWindow splash = new JSplashWindow();	//软件启动界面
     splash.start();
     System.out.println("JS");
    
     /*  显示启动界面，3秒钟后自动消失  */
    
  }
}
