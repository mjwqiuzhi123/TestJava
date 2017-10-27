package com.mjw.JSON.test;
import java.io.IOException;
import java.text.ParseException;

import org.codehaus.jackson.map.ObjectMapper;
  
public class JacksonDemo { 
  public static void main(String[] args) throws ParseException, IOException { 
    String json = "{\"name\":\"С��\",\"age\":20,\"birthday\":19890820,\"email\":\"xiaomin@sina.com\"}"; 
      
    /** 
     * ObjectMapper֧�ִ�byte[]��File��InputStream���ַ��������ݵ�JSON�����л��� 
     */
    ObjectMapper mapper = new ObjectMapper(); 
    User user = mapper.readValue(json, User.class); 
    System.out.println(user.getName() + " " + user.getAge() + " " + user.getBirthday() + " " + user.getEmail()); 
  } 
}