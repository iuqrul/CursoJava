package appExamen5_1;

import java.io.*;

public class UtilitiesSystem {

   public static void foo (){
        File pwd=new File(System.getProperty("user.dir"));
        if (pwd.isDirectory()){
             File [] bar=pwd.listFiles();
             for (int i=0;i<bar.length;i++){
                 System.out.println (bar[i].getName());
             }
        }else{
            System.out.println ("Error. The argument is not a directory");
        }
   }
	
}
