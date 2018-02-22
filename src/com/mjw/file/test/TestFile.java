package com.mjw.file.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author admin
 * 
 */
public class TestFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeFile();
		try {
			deletefile("F:/AAA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Test for mkdir() and mkdirs() and createNewFile() 
	public static void makeFile(){
		File file1 = new File("F:/AAA/BBB/CCC");
        if (file1.mkdirs()) {
            System.out.println("�༶���ļ��д����ɹ�����������ļ�Ŀ¼Ϊ��" + file1.getPath() + ",�ϼ��ļ�Ϊ:" + file1.getParent());
        }

        File file2 = new File("F:/AAA/BBB/CCC/DDD");
        if (file2.mkdir()) {
            System.out.println("���ļ��� DDD �����ɹ�����������ļ�Ŀ¼Ϊ��" + file2.getPath() + ",�ϼ��ļ�Ϊ:" + file2.getParent());
        }

        File file3 = new File("F:/AAA/BBB/CCC/DDD","mytest.txt");
        try {
            if (file3.createNewFile()) {
                System.out.println("�༶���ļ������ļ������ɹ��������˵��ļ�Ϊ:" + file3.getAbsolutePath() + ",�ϼ��ļ�Ϊ:" + file3.getParent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
     * ɾ��ĳ���ļ����µ������ļ��к��ļ�
     *
     * @param delpath
     * @throws FileNotFoundException IOException
     * @return boolean
     */
    public static boolean deletefile(String delpath) throws Exception {
        File file = new File(delpath);
        if (file.isDirectory()) {
            String[] filelist = file.list();
            for (String delFile : filelist) {
                File delfile = new File(delpath + File.separator + delFile);
                if (delfile.isDirectory()) {
                    deletefile(delpath + File.separator + delFile);
                } else
                    System.out.println("����ɾ���ļ���" + delfile.getPath() + ",ɾ���Ƿ�ɹ���" + delfile.delete());
            }
            System.out.println("����ɾ�����ļ��У�" + file.getPath() + ",ɾ���Ƿ�ɹ���" + file.delete());
        } else
            System.out.println("����ɾ���ļ���" + file.getPath() + ",ɾ���Ƿ�ɹ���" + file.delete());
        return true;
    }
	
}
