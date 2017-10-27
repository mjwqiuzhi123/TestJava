package com.mjw.webservice.test;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
//����������webservice  
@WebService  
public class Function{  
  
    //�÷�������Ҫ��¶������Ӧ�ó�����õķ���  
    public String transWords(String words){  
        String res="";  
        for(char ch : words.toCharArray()){  
            res+="*"+ch+" ";  
        }  
        return res;  
    }  
  
    //��������ʹ��main�������������ǵ�service  
    public static void main(String[] args){  
        Endpoint.publish("http://localhost:9001/Service/Function",new Function());  
        System.out.println("Publish Success~");  
    }  
}