/*
 * FileCopy.java
 *
 */
 package newpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileCopy {
  public void amain(String fromfile,String tofile) {
	  System.out.println("FC");  
    
    /////////////////////////////////////////////////////////////////////////////
    //  注意：这里需给出文件路径
    ////////////////////////////////////////////////////////////////////////////
    
    File fromFile = new File(fromfile);
    File afromFile = new File(tofile);

    if(!fromFile.exists()) {
      System.out.printf("复制文件：%s 不存在！",
                                       fromFile.getAbsolutePath());
      System.out.println();
    //  System.exit(1);
    }
    
    File toFile = createBackupFile(afromFile);
    FileInputStream inFile = null;
    FileOutputStream outFile = null;
    try {
      inFile = new FileInputStream(fromFile); 
      outFile = new FileOutputStream(toFile);

    } catch(FileNotFoundException e) {
      e.printStackTrace(System.err);
      assert false;
    }

    FileChannel inChannel = inFile.getChannel();    
    FileChannel outChannel = outFile.getChannel(); 

    try {
      int bytesWritten = 0;
      long byteCount = inChannel.size();
      while(bytesWritten<byteCount) {
        bytesWritten += inChannel.transferTo(bytesWritten, 
                                             byteCount-bytesWritten,
                                             outChannel); 
      }
      
      System.out.printf("文件复制成功！ \n%d 比特字节复制到文件： %s%n",
                                     byteCount, toFile.getAbsolutePath());
      System.out.println();
      inFile.close();
      outFile.close();

    } catch(IOException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  //  System.exit(0); 
  }
 
  // Method to create a unique backup File object  
  public static File createBackupFile(File aFile) {System.out.println("FC");
     aFile = aFile.getAbsoluteFile();          // Ensure we have an absolute path
     File parentDir = new File(aFile.getParent());    // Get the parent directory
     String name = aFile.getName();                   // Get the file name
     int period = name.indexOf('.');           // Find the extension separator
     if(period == -1) {                        // If there isn't one
       period = name.length();                 // set it to the end of the string
     }
     String nameAdd = "_backup";               // ***********************************

     // Create a File object that is unique
     File backup = aFile;
     int i=0;
     while(backup.exists()) {  
      //  System.out.println(""+backup.getName());         
        i++;
        name = backup.getName();               // Get the current name of the file
  //     backup = new File(parentDir, name.substring(0,period) // add _backup again
  //                     + nameAdd + name.substring(period));
       
        backup = new File(parentDir,
                        "本帅"+i+".txt");
        
        
        period += nameAdd.length();            // Increment separator index    
     }
     return backup;   
  }
}

