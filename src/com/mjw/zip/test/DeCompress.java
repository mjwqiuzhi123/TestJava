package com.mjw.zip.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DeCompress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** 
         * ��ѹ�ļ� 
         */  
        File zipFile = new File("D:\\NODEBACKUP\\cpslite\\99.zip"); 
        String unCompressdir = zipFile.getParent() + File.separator + zipFile.getName().substring(0,zipFile.getName().lastIndexOf("."));
        System.out.println(unCompressdir);
        String path = "d:/zipfile/";  
        try {
			unZipFiles(zipFile, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 
     * ��ѹ��ָ��Ŀ¼ 
     * @param zipPath 
     * @param descDir 
     * @author isea533 
     */  
    public static void unZipFiles(String zipPath,String descDir)throws IOException{  
        unZipFiles(new File(zipPath), descDir);  
    }  
    /** 
     * ��ѹ�ļ���ָ��Ŀ¼ 
     * @param zipFile 
     * @param descDir 
     * @author isea533 
     */  
    @SuppressWarnings({ "rawtypes", "resource" })  
    public static void unZipFiles(File zipFile,String descDir)throws IOException{  
        File pathFile = new File(descDir);  
        if(!pathFile.exists()){  
            pathFile.mkdirs();  
        }  
		ZipFile zip = new ZipFile(zipFile);  
        for(Enumeration entries = zip.entries();entries.hasMoreElements();){  
            ZipEntry entry = (ZipEntry)entries.nextElement();  
            String zipEntryName = entry.getName();  
            InputStream in = zip.getInputStream(entry);  
			String outPath = (descDir + zipEntryName).replaceAll("\\*", "/"); 
            //�ж�·���Ƿ����,�������򴴽��ļ�·��  
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));  
            if(!file.exists()){  
                file.mkdirs();  
            }  
            //�ж��ļ�ȫ·���Ƿ�Ϊ�ļ���,����������Ѿ��ϴ�,����Ҫ��ѹ  
            if(new File(outPath).isDirectory()){  
                continue;  
            }  
            //����ļ�·����Ϣ  
            System.out.println(outPath);  
              
            OutputStream out = new FileOutputStream(outPath);  
            byte[] buf1 = new byte[1024];  
            int len;  
            while((len=in.read(buf1))>0){  
                out.write(buf1,0,len);  
            }  
            in.close();  
            out.close();  
            }  
        System.out.println("******************��ѹ���********************");  
    }  

}
