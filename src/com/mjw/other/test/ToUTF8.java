package com.mjw.other.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class ToUTF8 {
	public static void main(String[] args) {
		
	}
	
	public static String ReadFile(String path) throws IOException { 
        File file = new File( path); 
        if (! file.exists()) {
             throw new IOException( "文件不存在" );
            }
        BufferedReader reader = null; 
        StringBuffer laststr = new StringBuffer(); 
       
        InputStream in= new FileInputStream( file);
        try { 
              // reader = new BufferedReader( new UnicodeReader(in,"utf-8" )); 
            String tempString = null; 
            while (( tempString = reader.readLine()) != null) { 
                   laststr.append( tempString);
            } 
            reader.close(); 
        } catch (IOException e) { 
             throw new IOException( "文件读写错误" );
        } finally { 
            if ( reader != null) { 
                try { 
                    reader.close(); 
                } catch (IOException e1) { 
                   throw new IOException( "文件流关闭错误" );
                } 
            } 
        } 
        return laststr.toString(); 
    } 
	{
		//用于防止科学计数法的显示
		DecimalFormat df = new DecimalFormat("0");  
		//String whatYourWant = df.format(cell.getNumericCellValue());  
	}
}
