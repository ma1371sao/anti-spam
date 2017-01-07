/*
 * ImageTable.java
 *
 * Created on 2008年12月4日, 下午2:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Administrator
 */
package newpackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;


public class ImageTable extends JTable{
	
	ImageIcon image=new ImageIcon("image/555556666777.jpg");//图片路径
	
	public ImageTable(String[][] value,String[] name){
		super(value,name);
		setGridColor(new Color(177,66,66));
		setRowSelectionAllowed(true);
		setSelectionForeground(Color.red);
		setSurrendersFocusOnKeystroke(true);System.out.println("IM1");
	}
        
        public ImageTable(int a,int b){
            super(a,b);System.out.println("IM2");
        }
	
	public Component prepareRenderer(TableCellRenderer renderer,int row,int column){
		Component c=super.prepareRenderer(renderer,row,column);
		System.out.println("IM3");
		if(c instanceof JComponent){
			((JComponent)c).setOpaque(false);
		}
		
		return c;
	}
	
	public void paint(Graphics g){System.out.println("IM4");
		setOpaque(false);
		Dimension d=getSize();
		
		for(int x=0;x<d.width;x+=image.getIconWidth()){System.out.println("IM7");
			for(int y=0;y<d.height;y+=image.getIconHeight()){
				g.drawImage(image.getImage(),x,y,null,null);
			}
		}
		
		super.paint(g);
	}
	 
}
