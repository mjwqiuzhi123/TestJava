package com.mjw.path.test;
import java.io.File;
 
public class TestDemo {
    public static void main(String[] args) throws Exception {
        File file = new File(".");
        // ����"."���ʾ��ǰ·��
        // new File(".") ��ʾ�õ�ǰ·�� ����һ��Fileʵ��,!!!�����Ǳ�ﴴ��һ�� . �ļ�
        String path = file.getCanonicalPath();
        System.out.println(path);
        //���file�����·��
         
         
        File file2 = new File("bcde.txt");
        boolean b = file2.createNewFile();//����Ǵ���һ����Ϊbcde.txt���ļ�  windows��֧���ļ���Ϊһ����"."
        if(b){
            System.out.println("�ڵ�ǰ·��"+path+"�´����ļ�bcde.txt�ɹ�");
        }else{
            //��bcde.txt�Ѿ�����,�ٴδ����ͻ�ʧ��,
            System.out.println("�ڵ�ǰ·��"+path+"�´����ļ�bcde.txtʧ��");
        }
    }
}